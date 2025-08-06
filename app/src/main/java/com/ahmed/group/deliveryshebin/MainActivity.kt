package com.ahmed.group.deliveryshebin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ahmed.group.deliveryshebin.utils.theme.DeliveryShebinTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryShebinTheme {}
        }
    }
}