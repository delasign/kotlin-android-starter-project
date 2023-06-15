// ktlint-disable filename
package com.delasign.samplestarterproject

import android.content.Context.RECEIVER_NOT_EXPORTED
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import com.delasign.samplestarterproject.models.notifications.SystemNotifications
import com.delasign.samplestarterproject.models.notifications.SystemNotificationsExtras

fun MainActivity.setupNotifications() {
    // Register all the intents that you want to observe.
    // Ensure that you state whether its your app only or external
    // https://delasign.com/blog/android-studio-kotlin-broadcast-recievers-export-or-not
    baseContext.registerReceiver(
        broadcastReceiver,
        IntentFilter(SystemNotifications.sampleIntent),
        RECEIVER_NOT_EXPORTED,
    )
    // OnLanguageUpdate
    baseContext.registerReceiver(
        broadcastReceiver,
        IntentFilter(SystemNotifications.onLanguageContentUpdateIntent),
        RECEIVER_NOT_EXPORTED,
    )
}

fun MainActivity.onSampleIntent(intent: Intent) {
    Log.i(
        identifier,
        "${DebuggingIdentifiers.actionOrEventInProgress} onSampleIntent $intent  ${DebuggingIdentifiers.actionOrEventInProgress}.",
    )
    // Check for Extras
    val extras = intent.extras
    if (extras != null) {
        // There are extras!
        val extra = extras.getInt(SystemNotificationsExtras.sample)
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventSucceded} onSampleIntent extra: $extra.",
        )
        // Do Something
    } else {
        // There are no extras
    }

    Log.i(
        identifier,
        "${DebuggingIdentifiers.actionOrEventSucceded} onSampleIntent Sequence Complete",
    )
}

fun MainActivity.onLanguageContentUpdateIntent(intent: Intent) {
    Log.i(
        identifier,
        "${DebuggingIdentifiers.actionOrEventInProgress} onLanguageContentUpdateIntent $intent  ${DebuggingIdentifiers.actionOrEventInProgress}.",
    )
    // Refresh UI
    setupUI()
    Log.i(
        identifier,
        "${DebuggingIdentifiers.actionOrEventSucceded} onLanguageContentUpdateIntent Sequence Complete",
    )
}
