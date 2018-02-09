package com.example.tanveerbashir.clear_sky

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview_main.layoutManager = LinearLayoutManager(this)
        fetchWeatherData()
    }

    private fun fetchWeatherData() {
        val gson = GsonBuilder().create()
        val client = OkHttpClient()
        val builder = Uri.Builder()

        builder.scheme("https")
                .authority("api.darksky.net")
                .appendPath("forecast")
                .appendPath("72863521b180d169af5fd702f776bfc4")
                .appendPath("40.2600, -74.7909")

        val url = builder.build().toString()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                val weather = gson.fromJson(body, Weather::class.java)

                runOnUiThread {
                    recyclerview_main.adapter = WeatherAdapter(weather)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed!!")
            }
        })
    }
}
