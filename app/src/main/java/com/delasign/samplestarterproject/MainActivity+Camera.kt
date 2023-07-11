// ktlint-disable filename
package com.delasign.samplestarterproject

import android.content.Context
import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

// MARK: LifeCycle
@ExperimentalGetImage
fun MainActivity.startCamera() {
    cameraExecutor = Executors.newSingleThreadExecutor()
}

fun MainActivity.stopCamera() {
    cameraExecutor.shutdown()
}

// MARK: SUSPEND

suspend fun Context.getCameraProvider(): ProcessCameraProvider = suspendCoroutine { continuation ->
    ProcessCameraProvider.getInstance(this).also { cameraProvider ->
        cameraProvider.addListener({
            continuation.resume(cameraProvider.get())
        }, ContextCompat.getMainExecutor(this))
    }
}