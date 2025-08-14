package com.habib.group.deliveryshebin.rider.utils.imagePicker.utils

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FileProviderHelper(private val context: Context) {

    fun getUri(file: File? = null): Uri {
        val providerFile = file ?: createFile(generateFileName())
        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            providerFile
        )
    }

    fun getFileFromAbsolutePath(path: String?): File? {
        if (path.isNullOrBlank()) return null

        val directory = context.externalCacheDir ?: context.cacheDir

        val realPath = File(
            directory,
            path.substringAfterLast("/")
        )

        return if (realPath.exists()) realPath else null
    }

    fun createFile(fileName: String): File {
        val directory = context.externalCacheDir ?: context.cacheDir
        return File.createTempFile(fileName, ".jpg", directory)
    }

    fun generateFileName(): String {
        val dateFormat = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)
        val timeStamp = dateFormat.format(Date())
        return "IMG_DeliveryShebin_$timeStamp"
    }

    fun isTempHasFiles(): Boolean {
        val directory = context.externalCacheDir ?: context.cacheDir
        val dirSizeInBytes = getDirectorySize(directory)
        val dirSizeInMB = dirSizeInBytes / (1024 * 1024)
        return dirSizeInMB > 0
    }

    fun deleteCashFile() = deleteDirectory(context.externalCacheDir ?: context.cacheDir)

    private fun deleteDirectory(directory: File): Boolean {
        if (directory.exists()) {
            directory.listFiles()?.forEach { file ->
                if (file.isDirectory) {
                    deleteDirectory(file)
                } else {
                    file.delete()
                }
            }
        }
        return directory.delete()
    }

    private fun getDirectorySize(directory: File): Long {
        var size = 0L
        if (directory.exists()) {
            directory.listFiles()?.forEach { file ->
                size += if (file.isDirectory) {
                    getDirectorySize(file)
                } else {
                    file.length()
                }
            }
        }
        return size
    }
}