package com.habib.group.deliveryshebin.rider.utils.imagePicker.utils

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import com.habib.group.deliveryshebin.rider.utils.imagePicker.utils.UriConfig


@Composable
fun askForCameraPermission(
    isGranted: (Boolean) -> Unit
) = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission()
) { isGranted(it) }

@Composable
fun launchCamera(
    uri: Uri,
    uriConfig: UriConfig,
    onImageSelected: (Uri?) -> Unit
) = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.TakePicture()
) { success ->
    if (success) {
        onImageSelected(uriConfig.configureUri(uri))
    } else {
        uriConfig.configureUri(null)
    }
}