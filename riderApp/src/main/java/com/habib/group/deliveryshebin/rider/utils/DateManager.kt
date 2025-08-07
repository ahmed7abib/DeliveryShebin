package com.habib.group.deliveryshebin.rider.utils

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale


fun getCurrentDate() = Calendar.getInstance().getTime().toString()

fun String.parseDate(): Date {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX", Locale.getDefault())
    return format.parse(this) ?: throw IllegalArgumentException("Invalid date format")
}

fun String.formatDate(): String {
    var date: String

    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
            LocalDateTime.parse(this)
            val parsedDate = LocalDateTime.parse(this)
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            date = parsedDate.format(formatter)
        }

        else -> {
            try {
                val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS", Locale.ENGLISH)
                val parsedDate = inputFormat.parse(this)
                val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                date = parsedDate?.let { outputFormat.format(it) } ?: ""
            } catch (_: Exception) {
                date = ""
            }
        }
    }

    return date
}