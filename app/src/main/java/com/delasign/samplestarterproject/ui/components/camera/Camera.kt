package com.delasign.samplestarterproject.ui.components.camera

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import com.delasign.samplestarterproject.getCameraProvider
import java.util.concurrent.Executor


@Composable
fun Camera(
    executor: Executor,
    onError: (ImageCaptureException) -> Unit
) {
    // MARK: VARIABLES
    val context = LocalContext.current
    val identifier = "[CameraView]"

    // MARK: CAMERA SETUP AND RENDER
    // 1
    val lensFacing = CameraSelector.LENS_FACING_BACK

    val lifecycleOwner = LocalLifecycleOwner.current
    // Setup Basic Camera
    val preview = Preview.Builder().build()
    val previewView = remember { PreviewView(context) }
    // Image Capture Functionality
    val imageCapture: ImageCapture = remember {
        ImageCapture.Builder()
            .setCaptureMode(CAPTURE_MODE_MAXIMIZE_QUALITY)
            .build()
    }

    val cameraSelector = CameraSelector.Builder()
        .requireLensFacing(lensFacing)
        .build()
    LaunchedEffect(lensFacing) {
        val cameraProvider = context.getCameraProvider()
        cameraProvider.unbindAll()
        val camera = cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview,
            imageCapture,
        )

        preview.setSurfaceProvider(previewView.surfaceProvider)
        previewView.scaleType = PreviewView.ScaleType.FILL_CENTER
    }
    // 3
    AndroidView({ previewView }, modifier = Modifier.fillMaxSize())
}