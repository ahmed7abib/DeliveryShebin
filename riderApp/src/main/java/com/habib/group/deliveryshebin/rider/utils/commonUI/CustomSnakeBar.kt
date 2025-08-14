package com.habib.group.deliveryshebin.rider.utils.commonUI

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CustomSnakeBar(text: String) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch {
            SnackbarHostState().showSnackbar(message = text, duration = SnackbarDuration.Short)
        }
    }
}