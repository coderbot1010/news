package com.mohamed.news.utils

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter
{
    private val days = arrayOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    private val months = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")

    fun format(date: Long): String
    {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = date
        return "${days[calendar.get(Calendar.DAY_OF_WEEK) - 1]}, ${calendar.get(Calendar.DAY_OF_MONTH)} ${months[calendar.get(Calendar.MONTH)]} ${calendar.get(Calendar.YEAR)}    ${calendar.get(Calendar.HOUR_OF_DAY)}:${calendar.get(Calendar.MINUTE)}"
    }

    fun parse(dateStamp: String): Date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH).parse(dateStamp)!!
}