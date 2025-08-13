package com.habib.group.deliveryshebin.rider.utils.commonUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomButton(
    text: String,
    textColor: Color,
    modifier: Modifier,
    backgroundColor: Color,
    textSize: TextUnit = 14.sp,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = textSize,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CustomButton(
    icon: Int,
    text: String,
    textColor: Color,
    modifier: Modifier,
    backgroundColor: Color,
    textSize: TextUnit = 14.sp,
    layoutDirection: LayoutDirection = LayoutDirection.Ltr,
    onClick: () -> Unit
) {
    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(backgroundColor)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {

            HorizontalSpace(16.dp)

            Image(
                contentDescription = null,
                painter = painterResource(icon),
                modifier = Modifier.size(32.dp)
            )

            HorizontalSpace(8.dp)

            Text(
                text = text,
                color = textColor,
                fontSize = textSize,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            HorizontalSpace(16.dp)
        }
    }
}