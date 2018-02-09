package com.example.tanveerbashir.clear_sky

import org.json.JSONObject

/**
 * Created by tanveerbashir on 2/7/18.
 */
data class Currently (val time: Int,
                      val summary: String,
                      val icon: String,
                      val nearestStormDistance: Double,
                      val nearestStormBearing: Double,
                      val precipIntensity: Double,
                      val precipProbability: Double,
                      val temperature: Double,
                      val apparentTemperature: Double,
                      val dewPoint: Double,
                      val humidity: Double,
                      val pressure: Double,
                      val windSpeed: Double,
                      val windGust: Double,
                      val windBearing: Double,
                      val cloudCover: Double,
                      val uvIndex: Int,
                      val visibility: Double,
                      val ozone: Double)
/*
    val time: Int = 0
    val summary: String = ""
    val icon: String = ""
    val nearestStormDistance: Int = 0
    val nearestStormBearing: Int = 0
    val precipIntensity: Int = 0
    val precipProbability: Int = 0
    val temperature: Double = 0.0
    val apparentTemperature: Double = 0.0
    val dewPoint: Double = 0.0
    val humidity: Double = 0.0
    val pressure: Double = 0.0
    val windSpeed: Double = 0.0
    val windGust: Double = 0.0
    val windBearing: Double = 0.0
    val cloudCover: Double = 0.0
    val uvIndex: Int = 0
    val visibility: Int = 0
    val ozone: Double = 0.0


    init {
        time = currently.getInt("time")
        summary = currently.getString("summary")
        icon = currently.getString("icon")
        nearestStormDistance = currently.getInt("nearestStormDistance")
        nearestStormBearing = currently.getInt("nearestStormBearing")
        precipIntensity = currently.getInt("precipIntensity")
        precipProbability = currently.getInt("precipProbability")
        temperature = currently.getDouble("temperature")
        apparentTemperature = currently.getDouble("apparentTemperature")
        dewPoint = currently.getDouble("dewPoint")
        humidity = currently.getDouble("humidity")
        pressure = currently.getDouble("pressure")
        windSpeed = currently.getDouble("windSpeed")
        windGust = currently.getDouble("windGust")
        windBearing = currently.getDouble("windBearing")
        cloudCover = currently.getDouble("cloudCover")
        uvIndex = currently.getInt("uvIndex")
        visibility = currently.getInt("visibility")
        ozone = currently.getDouble("ozone")
    }
}
        */
