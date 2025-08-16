package com.habib.group.deliveryshebin.rider.utils.commonUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun CustomIcon(
    iconId: Int,
    iconColor: Color,
    size: Int,
    containerColor: Color,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .size(size.dp)
            .background(containerColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            tint = iconColor,
            contentDescription = null,
            painter = painterResource(iconId),
            modifier = Modifier.size((size.dp * 0.5f))
        )
    }
}