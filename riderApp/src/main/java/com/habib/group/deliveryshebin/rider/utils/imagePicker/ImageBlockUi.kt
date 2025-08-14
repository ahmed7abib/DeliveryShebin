package com.habib.group.deliveryshebin.rider.utils.imagePicker

import android.Manifest
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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.habib.group.deliveryshebin.rider.R
import com.habib.group.deliveryshebin.rider.utils.imagePicker.utils.FileProviderHelper
import com.habib.group.deliveryshebin.rider.utils.imagePicker.utils.UriConfig
import com.habib.group.deliveryshebin.rider.utils.imagePicker.utils.askForCameraPermission
import com.habib.group.deliveryshebin.rider.utils.imagePicker.utils.launchCamera
import com.habib.group.deliveryshebin.rider.utils.theme.Black


@Composable
fun ImagePickerBlock(
    text: String,
    blockShape: BlockShape,
    modifier: Modifier = Modifier,
    onImageSelected: (Uri?) -> Unit
) {
    val context = LocalContext.current
    val fileProviderHelper by lazy { FileProviderHelper(context) }
    var cameraIconVisibility by remember { mutableStateOf(true) }
    var selectedImageToShow by remember { mutableStateOf<Uri?>(null) }

    val imageUri = fileProviderHelper.getUri()

    val cameraLauncher = launchCamera(
        imageUri,
        UriConfig(context, fileProviderHelper)
    ) {
        onImageSelected(it)
        selectedImageToShow = it
        cameraIconVisibility = false
    }

    val startCameraPicker = askForCameraPermission { isGranted ->
        if (isGranted) {
            cameraLauncher.launch(imageUri)
        }
    }

    val clip = when (blockShape) {
        BlockShape.CIRCLE_BLOCK -> CircleShape
        BlockShape.RECTANGLE_BLOCK -> RoundedCornerShape(8.dp)
    }

    Box(
        modifier = modifier
            .clip(shape = clip)
            .background(Color.Gray.copy(alpha = 0.1f))
    ) {
        Image(
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(model = selectedImageToShow)
        )

        if (cameraIconVisibility) {
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
                        .size(50.dp)
                        .padding(8.dp)
                        .clickable { startCameraPicker.launch(Manifest.permission.CAMERA) }
                )

                Text(text, fontSize = 10.sp)
            }
        } else {

            val align = when (blockShape) {
                BlockShape.RECTANGLE_BLOCK -> Alignment.TopEnd
                BlockShape.CIRCLE_BLOCK -> Alignment.BottomCenter
            }

            Image(
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .padding(8.dp)
                    .align(align)
                    .clickable {
                        onImageSelected(null)
                        selectedImageToShow = null
                        cameraIconVisibility = true
                    },
                painter = painterResource(R.drawable.ic_close),
            )
        }
    }
}

enum class BlockShape { CIRCLE_BLOCK, RECTANGLE_BLOCK }