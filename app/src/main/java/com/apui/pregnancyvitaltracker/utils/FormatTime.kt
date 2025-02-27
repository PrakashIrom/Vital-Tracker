package com.apui.pregnancyvitaltracker.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.formatTime(): String {
    val sdf = SimpleDateFormat("EEE, dd MMM yyyy hh:mm a", Locale.ENGLISH)
    return sdf.format(Date(this))
}