package com.delasign.samplestarterproject.utils.system

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

fun getOrientation(context: Context): Int {
    return context.display?.rotation ?: 0
}

@Composable
fun getOrientation(): Int {
    val context = LocalContext.current
    return context.display?.rotation ?: 0
}
