package com.delasign.samplestarterproject.utils

import android.content.Context
import android.util.Log
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import java.io.BufferedReader
import java.io.InputStreamReader

fun ReadJSONFromAssets(context: Context, path: String): String {
    val identifier = "[ReadJSON]"
    try {
        val file = context.assets.open("$path")
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventSucceded} Found File: $file.",
        )
        val bufferedReader = BufferedReader(InputStreamReader(file))
        val stringBuilder = StringBuilder()
        bufferedReader.useLines { lines ->
            lines.forEach {
                stringBuilder.append(it)
            }
        }
        Log.i(
            identifier,
            "getJSON  ${DebuggingIdentifiers.actionOrEventSucceded} stringBuilder: $stringBuilder.",
        )
        val jsonString = stringBuilder.toString()
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventSucceded} JSON as String: $jsonString.",
        )
        return jsonString
    } catch (e: Exception) {
        Log.e(
            identifier,
            "${DebuggingIdentifiers.actionOrEventFailed} Error reading JSON: $e.",
        )
        e.printStackTrace()
        return ""
    }
}
