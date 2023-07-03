// ktlint-disable filename
package com.delasign.samplestarterproject.utils.system

import android.content.Context
import android.view.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

fun isLandscape(context: Context): Boolean {
    val orientation = context.display?.rotation ?: 0
    return orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270
}

@Composable
fun isLandscape(): Boolean {
    val context = LocalContext.current
    val orientation = context.display?.rotation ?: 0
    return orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270
}
