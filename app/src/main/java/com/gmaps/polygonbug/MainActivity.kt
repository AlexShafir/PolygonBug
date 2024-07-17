package com.gmaps.polygonbug

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions
import java.util.Locale


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val languageToLoad = "en"
        val locale = Locale(languageToLoad)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )

        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync { map ->
            val polygon = map.addPolygon(
                PolygonOptions()
                    .add(LatLng(0.0, 0.0), LatLng(0.0, 5.0), LatLng(3.0, 5.0), LatLng(0.0, 0.0))
                    .strokeColor(Color.RED)
                    .fillColor(Color.BLUE)
            )

            val marker = map.addMarker(MarkerOptions().position(LatLng(0.0, 0.0)))!!

            polygon.remove()

            map.clear() // Not working for marker as well
        }

    }
}