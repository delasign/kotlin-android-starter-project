// ktlint-disable filename
package com.delasign.samplestarterproject.coordinators.notificationCoordinator

import android.content.Intent
import com.delasign.samplestarterproject.models.constants.kAppBundleId
import com.delasign.samplestarterproject.models.notifications.SystemNotifications
import com.delasign.samplestarterproject.models.notifications.SystemNotificationsExtras
import com.delasign.samplestarterproject.models.states.ExperienceStates

fun NotificationCoordinator.sendOnLanguageContentUpdateIntent() {
    // Curate Notification
    val intent = Intent(SystemNotifications.onLanguageContentUpdateIntent)
    // Set the package
    intent.setPackage(kAppBundleId)
    // Send Notification - This is found in the declaration file
    sendNotification(intent)
}

fun NotificationCoordinator.sendOnUpdateExperienceIntent(state: ExperienceStates) {
    // Curate Notification
    val intent = Intent(SystemNotifications.onUpdateExperienceStateIntent)
    // Add data (Extras)
    intent.putExtra(
        SystemNotificationsExtras.experienceState,
        state.ordinal,
    )
    // Set the package
    intent.setPackage(kAppBundleId)
    // Send Notification - This is found in the declaration file
    sendNotification(intent)
}

fun NotificationCoordinator.sendSampleIntent() {
    // Curate Notification
    val intent = Intent(SystemNotifications.sampleIntent)
    // Set the package
    intent.setPackage(kAppBundleId)
    // Send Notification - This is found in the declaration file
    sendNotification(intent)
}

fun NotificationCoordinator.sendSampleIntent(extra: String) {
    // Curate Notification
    val intent = Intent(SystemNotifications.sampleIntent)
    // Add data (Extras)
    intent.putExtra(
        SystemNotificationsExtras.sample,
        extra,
    )
    // Set the package
    intent.setPackage(kAppBundleId)
    // Send Notification - This is found in the declaration file
    sendNotification(intent)
}
