package com.ahmed.group.deliveryshebin.utils.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ahmed.group.deliveryshebin.R
import androidx.compose.material3.Typography


private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    secondary = Secondary,
    tertiary = Tertiary
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    tertiary = Tertiary
)

@Composable
fun DeliveryShebinTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val customTypography = Typography(
        bodyLarge = TextStyle(
            fontFamily = customFontFamily(),
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp,
            fontWeight = FontWeight.Bold
        ),
        titleLarge = TextStyle(
            fontFamily = customFontFamily(),
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp,
            fontWeight = FontWeight.SemiBold
        ),
        labelSmall = TextStyle(
            fontFamily = customFontFamily(),
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp,
            fontWeight = FontWeight.Medium
        )
    )

    MaterialTheme(
        content = content,
        colorScheme = colorScheme,
        typography = customTypography
    )
}

@Composable
private fun customFontFamily(): FontFamily {
    val locale = LocalConfiguration.current.locales[0]
    val language = locale.language
    return if (language == "ar") ArabicFont else EnglishFont
}

private val ArabicFont = FontFamily(Font(R.font.ubuntu_font, FontWeight.Normal))
private val EnglishFont = FontFamily(Font(R.font.ubuntu_font, FontWeight.Normal))