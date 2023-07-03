// ktlint-disable filename
package com.delasign.samplestarterproject.coordinators.dataCoordinator

import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.HttpHeaderParser
import com.delasign.samplestarterproject.coordinators.dataCoordinator.DataCoordinator.Companion.identifier
import com.delasign.samplestarterproject.models.api.SampleError
import com.delasign.samplestarterproject.models.api.SampleResponse
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import com.delasign.samplestarterproject.utils.data.GsonRequest
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import org.json.JSONObject
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset

fun DataCoordinator.sampleAPI(
    email: String,
    onSuccess: () -> Unit,
    onError: () -> Unit,
) {
    val apiRequestQueue = this.apiRequestQueue ?: return
    // / Create the payload
    val payload = JSONObject()
    payload.put("email", email)
    // / Create the Headers
    var headers: MutableMap<String, String> = HashMap<String, String>()
    headers.put("A-sample-key", "a-sample-key")
    // Create the Request
    val request = GsonRequest(
        url = "a-sample-url",
        clazz = SampleResponse::class.java,
        method = Request.Method.POST,
        headers = headers,
        jsonPayload = payload,
        listener = {
            Log.i(
                identifier,
                "${DebuggingIdentifiers.actionOrEventSucceded} request : $it.",
            )
            onSuccess()
        },
        errorListener = {
            val response = it.networkResponse
            try {
                val errorJson = String(
                    response.data,
                    Charset.forName(HttpHeaderParser.parseCharset(response.headers)),
                )
                val errorObj = Gson().fromJson(errorJson, SampleError::class.java)
                Log.i(
                    identifier,
                    "${DebuggingIdentifiers.actionOrEventFailed} request : ${errorObj.error}",
                )
                onError()
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            } catch (e: JsonSyntaxException) {
                e.printStackTrace()
            }
        },
    )
    // Make the request
    apiRequestQueue.add(request)
}
