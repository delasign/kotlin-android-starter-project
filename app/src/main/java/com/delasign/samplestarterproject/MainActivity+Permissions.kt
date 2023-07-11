// ktlint-disable filename
package com.delasign.samplestarterproject

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

fun MainActivity.requestCameraPermission() {
    when {
        ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED -> {
            Log.i(identifier, "Permission previously granted")
            this.shouldShowCamera.value = true
        }

        ActivityCompat.shouldShowRequestPermissionRationale(
            this,
            Manifest.permission.CAMERA
        ) -> Log.i(identifier, "Show camera permissions dialog")

        else -> requestPermissionLauncher.launch(Manifest.permission.CAMERA)
    }
}