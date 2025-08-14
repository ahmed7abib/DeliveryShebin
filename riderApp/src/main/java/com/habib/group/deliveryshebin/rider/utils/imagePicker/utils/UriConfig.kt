package com.habib.group.deliveryshebin.rider.utils.imagePicker.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.net.Uri
import androidx.exifinterface.media.ExifInterface
import java.io.FileOutputStream

class UriConfig(
    private val context: Context,
    private val fileProviderHelper: FileProviderHelper
) {

    fun configureUri(uri: Uri?): Uri? {
        if (uri == null) return null
        val originalBitmap = getBitmapFromUri(uri)
        if (originalBitmap == null) return null

        val rotatedBitmap = rotateBitmapIfRequired(originalBitmap, uri)
        val newFileData = saveBitmapToFile(rotatedBitmap)
        return newFileData.first
    }

    private fun getBitmapFromUri(uri: Uri): Bitmap? {
        return context.contentResolver.openInputStream(uri)?.use { BitmapFactory.decodeStream(it) }
    }

    private fun saveBitmapToFile(bitmap: Bitmap): Pair<Uri?, String> {
        val fileName = fileProviderHelper.generateFileName()
        val file = fileProviderHelper.createFile(fileName)
        FileOutputStream(file).use { out -> bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out) }
        return Pair(fileProviderHelper.getUri(file), fileName)
    }

    private fun rotateBitmapIfRequired(bitmap: Bitmap, uri: Uri): Bitmap {
        val inputStream = context.contentResolver.openInputStream(uri)
        val exif = inputStream?.use { ExifInterface(it) }
        val orientation = exif?.getAttributeInt(
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_NORMAL
        )

        val matrix = Matrix()
        when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> matrix.postRotate(90f)
            ExifInterface.ORIENTATION_ROTATE_180 -> matrix.postRotate(180f)
            ExifInterface.ORIENTATION_ROTATE_270 -> matrix.postRotate(270f)
            else -> return bitmap
        }

        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    }
}
