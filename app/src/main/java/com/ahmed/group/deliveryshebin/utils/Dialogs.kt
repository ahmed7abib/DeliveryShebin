package com.ahmed.group.deliveryshebin.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import io.github.farhanroy.composeawesomedialog.ComposeAwesomeDialog
import io.github.farhanroy.composeawesomedialog.utils.ComposeAwesomeDialogType


@Composable
fun ShowDialog(
    title: String,
    message: String,
    positiveButtonText: String,
    onPositiveClick: () -> Unit,
) {
    AlertDialog(
        modifier = Modifier.fillMaxWidth(0.92f),
        title = { Text(text = title, fontSize = 18.sp) },
        text = { Text(text = message) },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            decorFitsSystemWindows = true,
            usePlatformDefaultWidth = false,
        ),
        onDismissRequest = {},
        shape = RoundedCornerShape(20.dp),
        confirmButton = { TextButton(onClick = { onPositiveClick() }) { Text(text = positiveButtonText) } },
    )
}

@Composable
fun ShowDialog(
    title: String,
    message: String,
    positiveButtonText: String,
    onPositiveClick: () -> Unit,
    negativeButtonText: String,
    onNegativeClick: () -> Unit,
) {
    AlertDialog(
        modifier = Modifier.fillMaxWidth(0.92f),
        title = { Text(text = title, fontSize = 18.sp) },
        text = { Text(text = message) },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            decorFitsSystemWindows = true,
            usePlatformDefaultWidth = false,
        ),
        shape = RoundedCornerShape(20.dp),
        onDismissRequest = { onNegativeClick() },
        confirmButton = { TextButton(onClick = { onPositiveClick() }) { Text(text = positiveButtonText) } },
        dismissButton = { TextButton(onClick = { onNegativeClick() }) { Text(text = negativeButtonText) } },
    )
}

@Composable
fun ShowInfoDialog(
    title: String,
    message: String,
    status: DialogStatus,
    onDismiss: () -> Unit
) {
    val type = when (status) {
        DialogStatus.Info -> ComposeAwesomeDialogType.Info
        DialogStatus.Error -> ComposeAwesomeDialogType.Error
        DialogStatus.Success -> ComposeAwesomeDialogType.Success
    }

    ComposeAwesomeDialog(
        type = type,
        title = title,
        desc = message,
        onDismiss = { onDismiss() }
    )
}

enum class DialogStatus { Success, Error, Info }