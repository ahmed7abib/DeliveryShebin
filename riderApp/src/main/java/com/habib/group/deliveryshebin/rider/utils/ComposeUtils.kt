package com.habib.group.deliveryshebin.rider.utils

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.habib.group.deliveryshebin.rider.R


@Composable
fun getScreenHeight() = LocalConfiguration.current.screenHeightDp

@Composable
fun isLandscape() = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

@Composable
fun arabicFontBold() = FontFamily(Font(R.font.arabic_font_bold, FontWeight.Normal))

fun arabicFontLight() = FontFamily(Font(R.font.arabic_font_light, FontWeight.Light))