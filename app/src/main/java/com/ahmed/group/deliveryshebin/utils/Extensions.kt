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
import java.io.Serializable
import java.util.Locale
import java.util.UUID

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

fun Context.openSettings() {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
        data = Uri.fromParts("package", packageName, null)
    }
    startActivity(intent)
}
