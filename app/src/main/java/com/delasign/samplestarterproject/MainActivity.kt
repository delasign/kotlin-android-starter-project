package com.delasign.samplestarterproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.delasign.samplestarterproject.coordinators.languageCoordinator.LanguageCoordinator
import com.delasign.samplestarterproject.coordinators.languageCoordinator.updateCurrentContent
import com.delasign.samplestarterproject.coordinators.notificationCoordinator.NotificationCoordinator
import com.delasign.samplestarterproject.coordinators.notificationCoordinator.sendSampleIntent
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import com.delasign.samplestarterproject.models.notifications.SystemNotifications

class MainActivity : ComponentActivity() {
    // MARK: Variables
    val identifier = "[MainActivity]"

    // MARK: Broadcast Reciever
    val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.i(
                identifier,
                "${DebuggingIdentifiers.actionOrEventSucceded} ${DebuggingIdentifiers.notificationRecieved}  $intent | ${intent.extras}",
            )
            when (intent.action) {
                SystemNotifications.sampleIntent -> onSampleIntent(intent = intent)
                SystemNotifications.onLanguageContentUpdateIntent -> onLanguageContentUpdateIntent(intent = intent)
            }
        }
    }

    // MARK: Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNotifications()
        setupCoordinators()
        setupUI()
    }

    override fun onResume() {
        super.onResume()
        LanguageCoordinator.shared.updateCurrentContent()
        NotificationCoordinator.shared.sendSampleIntent()
    }

    // MARK: Setup Functionality
    private fun setupCoordinators() {
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventInProgress} Setting Up Coordinators.",
        )
        NotificationCoordinator.shared.initialize(context = baseContext)
        LanguageCoordinator.shared.initialize(context = baseContext)
    }
}
