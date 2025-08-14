package com.habib.group.deliveryshebin.rider.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.habib.group.deliveryshebin.rider.utils.theme.Black
import com.habib.group.deliveryshebin.rider.utils.theme.Orange
import com.habib.group.deliveryshebin.rider.utils.theme.White
import io.github.farhanroy.composeawesomedialog.ComposeAwesomeDialog
import io.github.farhanroy.composeawesomedialog.utils.ComposeAwesomeDialogType


@Composable
fun ShowActionDialog(
    title: String,
    message: String,
    positiveButtonText: String,
    onPositiveClick: () -> Unit,
    negativeButtonText: String = "",
    onNegativeClick: () -> Unit = {},
    layoutDirection: LayoutDirection = LayoutDirection.Rtl
) {
    val align = when (layoutDirection) {
        LayoutDirection.Ltr -> TextAlign.Left
        LayoutDirection.Rtl -> TextAlign.Right
    }

    AlertDialog(
        modifier = Modifier.fillMaxWidth(0.9f),
        title = {
            Text(
                text = title,
                color = White,
                fontSize = 18.sp,
                textAlign = align,
                fontFamily = arabicFontFamily()
            )
        },
        text = {
            Text(
                color = White,
                text = message,
                fontSize = 12.sp,
                textAlign = align,
                fontFamily = arabicFontFamily()
            )
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            decorFitsSystemWindows = true,
            usePlatformDefaultWidth = false,
        ),
        containerColor = Orange,
        shape = RoundedCornerShape(20.dp),
        onDismissRequest = { onNegativeClick() },
        confirmButton = {
            TextButton(onClick = { onPositiveClick() }) {
                Text(
                    color = Black,
                    text = positiveButtonText,
                    fontFamily = arabicFontFamily()
                )
            }
        },
        dismissButton = {
            TextButton(onClick = { onNegativeClick() }) {
                Text(
                    color = Black,
                    text = negativeButtonText,
                    fontFamily = arabicFontFamily()
                )
            }
        },
    )
}

@Composable
fun ShowInfoDialog(
    title: String,
    message: String,
    status: DialogStatus,
    onDismiss: () -> Unit,
    layoutDirection: LayoutDirection = LayoutDirection.Rtl
) {
    val type = when (status) {
        DialogStatus.Info -> ComposeAwesomeDialogType.Info
        DialogStatus.Error -> ComposeAwesomeDialogType.Error
        DialogStatus.Success -> ComposeAwesomeDialogType.Success
    }

    CompositionLocalProvider(
        LocalLayoutDirection provides layoutDirection
    ) {
        ComposeAwesomeDialog(
            type = type,
            title = title,
            desc = message,
            onDismiss = { onDismiss() }
        )
    }
}

enum class DialogStatus { Success, Error, Info }