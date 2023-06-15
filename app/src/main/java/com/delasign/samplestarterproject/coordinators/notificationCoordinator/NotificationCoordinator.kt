package com.delasign.samplestarterproject.coordinators.notificationCoordinator

import android.content.Context
import android.content.Intent
import android.util.Log
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers

class NotificationCoordinator {
    // MARK: Variables
    companion object {
        val shared = NotificationCoordinator()
        const val identifier = "[NotificationCoordinator]"
    }
    var context: Context? = null

    // MARK: Lifecycle
    fun initialize(context: Context) {
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventInProgress} initialize  ${DebuggingIdentifiers.actionOrEventInProgress}.",
        )
        this.context = context
    }

    // MARK: Send Notification Functionality
    fun sendNotification(intent: Intent) {
        val context = this.context ?: return
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventInProgress} sending notification with intent $intent  ${DebuggingIdentifiers.actionOrEventInProgress}.",
        )
        context.sendBroadcast(intent)
    }
}
