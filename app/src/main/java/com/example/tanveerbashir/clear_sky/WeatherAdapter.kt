package com.example.tanveerbashir.clear_sky

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_cell.view.*

/**
 * Created by tanveerbashir on 2/6/18.
 */



class WeatherAdapter(val weather: Weather): RecyclerView.Adapter<WeatherViewHolder>() {

    override fun getItemCount(): Int {
        return weather.daily.data.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherViewHolder {
        val context  = parent?.let { it.context } ?: null
        val infalter = LayoutInflater.from(context)
        val cellView = infalter.inflate(R.layout.recyclerview_cell, parent, false)
        return WeatherViewHolder(cellView)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder?, position: Int) {
        val dailyData = weather.daily.data.get(position)
        holder?.view?.dayTextView?.text = "${dailyData.time}"
        holder?.view?.trueHighTempView?.text = "${dailyData.temperatureHigh}"
        holder?.view?.trueLowTempView?.text = "${dailyData.temperatureLow}"
        val imageView = holder?.let { it.view.icon_imageView } ?: null
        imageView?.setImageResource(R.drawable.clearday)
    }
}
