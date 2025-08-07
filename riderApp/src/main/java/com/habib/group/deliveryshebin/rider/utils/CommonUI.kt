package com.habib.group.deliveryshebin.rider.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.habib.group.deliveryshebin.rider.R

@Composable
fun getAppLogo(): Int {
    val locale = LocalConfiguration.current.locales[0]
    val language = locale.language
    return if (language == "ar") R.drawable.ic_logo_ar else R.drawable.ic_logo_en
}

@Composable
fun customFontFamily(): FontFamily {
    val locale = LocalConfiguration.current.locales[0]
    val language = locale.language
    return if (language == "ar") {
        FontFamily(Font(R.font.ubuntu_font, FontWeight.Normal))
    } else {
        FontFamily(Font(R.font.ubuntu_font, FontWeight.Normal))
    }
}