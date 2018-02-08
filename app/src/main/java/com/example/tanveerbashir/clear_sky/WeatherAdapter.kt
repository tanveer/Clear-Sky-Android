package com.example.tanveerbashir.clear_sky

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.header_view.view.*
import kotlinx.android.synthetic.main.recyclerview_cell.view.*

/**
 * Created by tanveerbashir on 2/6/18.
 */



class WeatherAdapter(val weather: Weather): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val HEADER_TYPE = 0
    private var context: Context? = null
    private val currently = weather.currently
    private val icon: String
        get() = currently.icon.replace("-", "_")

    override fun getItemCount(): Int {
        return weather.daily.data.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        context  = parent?.let { it.context } ?: null

        val inflater = LayoutInflater.from(context)

        return if (viewType == HEADER_TYPE) {
            val header = inflater.inflate(R.layout.header_view, parent, false)
            HeaderViewHolder(header)
        } else {
            val cellView = inflater.inflate(R.layout.recyclerview_cell, parent, false)
            WeatherViewHolder(cellView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HeaderViewHolder) {
            val identifier = context?.resources?.getIdentifier(icon, "drawable", context?.packageName)
            val header = HeaderViewHolder(holder.itemView)
            val temp = currently.temperature.toInt().toString()
            val day = DateParser(currently.time.toLong()).day

            // set properties
            header.view.temp_textVIew.text =  temp + "º"
            header.view.summary_textView.text = currently.summary
            header.view.hightemp_textView.text = currently.apparentTemperature.toInt().toString()
            header.view.lowtemp_textView.text = currently.temperature.toInt().toString()
            header.view.day_textView.text = day

            // set weather icon
            identifier?.let { header.view.header_imageView?.setImageResource(it) }

        } else if (holder is WeatherViewHolder) {
            val dailyData = weather.daily.data.get(position)
            val icon = dailyData.icon.replace("-", "_")
            val identifier = context?.resources?.getIdentifier(icon, "drawable", context?.packageName)
            val listView = WeatherViewHolder(holder.itemView)
            val day = DateParser(dailyData.time.toLong()).day

            // set properties
            listView.view.dayTextView.text = day
            listView.view.trueHighTempView.text = dailyData.temperatureHigh.toInt().toString()
            listView.view.trueLowTempView.text = dailyData.temperatureLow.toInt().toString()

            // set weather icon
            identifier?.let { listView.view.icon_imageView?.setImageResource(it) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return HEADER_TYPE
        return position
    }
}
