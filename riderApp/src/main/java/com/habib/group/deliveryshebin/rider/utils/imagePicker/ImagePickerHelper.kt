package com.habib.group.deliveryshebin.rider.utils.imagePicker

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.habib.group.deliveryshebin.rider.R
import com.habib.group.deliveryshebin.rider.utils.theme.Black


@Composable
fun ImagePickerBlock(
    text: String,
    modifier: Modifier = Modifier,
    onImageSelected: (Uri) -> Unit
) {
    var selectedImage by remember { mutableStateOf<Uri?>(null) }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Gray.copy(alpha = 0.2f))
    ) {
        Image(
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(model = selectedImage)
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                tint = Black,
                contentDescription = null,
                painter = painterResource(R.drawable.ic_camera),
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .clickable {}
            )

            Text(text, fontSize = 10.sp)
        }
    }
}