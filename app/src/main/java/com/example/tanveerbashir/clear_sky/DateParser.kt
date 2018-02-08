package com.example.tanveerbashir.clear_sky

import android.text.format.DateFormat
import java.sql.Date
import java.text.SimpleDateFormat

/**
 * Created by tanveerbashir on 2/8/18.
 */

class DateParser(val timestamp: Long) {

    private val dateString: String
        get() = getDateFrom(timestamp)

    val day: String
        get() = getDayFrom(dateString)

    private fun getDateFrom(timestamp: Long): String {
        val timestamp = timestamp * 1000L
        val date = Date(timestamp)
        return DateFormat.format("MM/dd/yyyy", date) as String
    }

    private fun getDayFrom(s: String): String {
        val format = SimpleDateFormat("MM/dd/yyyy")
        val date = format.parse(s)
        return DateFormat.format("EEEE", date) as String
    }
}


//DateFormat.format("EEEE", date) // Thursday
//DateFormat.format("dd",   date) // 08
//DateFormat.format("MMM",  date) // Feb
//DateFormat.format("MM",   date) // 02
//DateFormat.format("yyyy", date) // 2018