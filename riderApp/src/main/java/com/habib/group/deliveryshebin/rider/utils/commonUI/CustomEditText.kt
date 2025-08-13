package com.habib.group.deliveryshebin.rider.utils.commonUI

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import com.habib.group.deliveryshebin.rider.utils.theme.Black
import com.habib.group.deliveryshebin.rider.utils.theme.White

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EditText(
    hint: String,
    maxLines: Int = 1,
    inputType: KeyboardType,
    modifier: Modifier = Modifier,
    layoutDirection: LayoutDirection = LayoutDirection.Rtl,
    onValueChange: (String) -> Unit
) {
    CompositionLocalProvider(
        LocalLayoutDirection provides layoutDirection
    ) {
        OutlinedTextField(
            value = "",
            maxLines = maxLines,
            singleLine = maxLines == 1,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                cursorColor = Black,
                focusedIndicatorColor = Black, unfocusedIndicatorColor = Gray,
                focusedContainerColor = White, unfocusedContainerColor = White
            ),
            keyboardOptions = KeyboardOptions(keyboardType = inputType),
            label = { Text(text = hint, color = Black, textAlign = TextAlign.Right) }
        )
    }
}