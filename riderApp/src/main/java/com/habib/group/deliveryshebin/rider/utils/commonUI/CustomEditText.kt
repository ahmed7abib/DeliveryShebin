package com.habib.group.deliveryshebin.rider.utils.commonUI

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import com.habib.group.deliveryshebin.rider.utils.theme.Black
import com.habib.group.deliveryshebin.rider.utils.theme.White
import com.habib.group.deliveryshebin.rider.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CustomEditText(
    label: String,
    initValue: String,
    placeholder: String,
    isSingleLine: Boolean,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = initValue,
        singleLine = isSingleLine,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(text = placeholder) },
        label = { Text(text = label, color = Black) },

        //        leadingIcon = {
        //            Icon(
        //                contentDescription = null,
        //                imageVector = Icons.Default.Person,
        //            )
        //        },
        //        trailingIcon = {
        //            if (initValue.isNotEmpty()) {
        //                Icon(
        //                    imageVector = Icons.Default.Clear,
        //                    contentDescription = "clear",
        //                    modifier = Modifier
        //                        .padding(end = 4.dp)
        //                        .clickable { onValueChange("") }
        //                )
        //            }
        //        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            capitalization = KeyboardCapitalization.Words,
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Black,
            unfocusedIndicatorColor = Gray,
            focusedContainerColor = White,
            unfocusedContainerColor = White
        )
    )
}
