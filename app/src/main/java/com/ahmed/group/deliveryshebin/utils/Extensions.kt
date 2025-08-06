package com.ahmed.group.deliveryshebin.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.Settings
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import java.io.Serializable
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.UUID

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun String.isValidEmail() =
    this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun getAlphaNumString() = UUID.randomUUID().toString()

fun Int.startTimer(onTick: (String) -> Unit, onFinish: () -> Unit): CountDownTimer? {
    return object : CountDownTimer(this * 1000L, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val minutes = (millisUntilFinished / 1000) / 60
            val seconds = (millisUntilFinished / 1000) % 60
            val formattedTime = String.format(
                Locale.getDefault(),
                "%02d:%02d",
                minutes, seconds
            )
            onTick(formattedTime)
        }

        override fun onFinish() {
            onFinish()
        }
    }.start()
}

fun Activity.hideKeyboard() {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = currentFocus

    if (view == null) {
        view = View(this)
    }

    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun getScreenWidth() = Resources.getSystem().displayMetrics.widthPixels

inline fun <reified T : Serializable?> Bundle.serializable(key: String): T? = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getSerializable(key) as? T
}

fun String.isArabic(): Boolean {
    val arabicRegex = "[\u0600-\u06FF\u0750-\u077F\u08A0-\u08FF]".toRegex()
    return arabicRegex.containsMatchIn(this)
}

fun Context.openSettings() {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
        data = Uri.fromParts("package", packageName, null)
    }
    startActivity(intent)
}

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