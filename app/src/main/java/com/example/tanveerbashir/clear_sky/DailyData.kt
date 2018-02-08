package com.example.tanveerbashir.clear_sky

/**
 * Created by tanveerbashir on 2/7/18.
 */
data class DailyData(var time: Int, var summary: String, val icon: String, val sunriseTime: Int, val sunsetTime: Int, val temperatureLow: Double, val temperatureHigh: Double)