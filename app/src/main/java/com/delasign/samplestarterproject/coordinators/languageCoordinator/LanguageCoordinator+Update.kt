// ktlint-disable filename
package com.delasign.samplestarterproject.coordinators.languageCoordinator

import android.util.Log
import com.delasign.samplestarterproject.coordinators.notificationCoordinator.NotificationCoordinator
import com.delasign.samplestarterproject.coordinators.notificationCoordinator.sendOnLanguageContentUpdateIntent
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import com.delasign.samplestarterproject.models.languageContent.Languages
import java.util.Locale

fun LanguageCoordinator.updateCurrentContent() {
    // Get the current system language
    systemLanguage = Locale.getDefault().language
    Log.i(
        "${LanguageCoordinator.identifier}",
        "${DebuggingIdentifiers.actionOrEventInProgress} updateCurrentContent language : $systemLanguage  ${DebuggingIdentifiers.actionOrEventInProgress}.",
    )
    // Set the Current Language
    currentLanguage = when (systemLanguage) {
        // Spanish US or Spain
        "es" -> Languages.SPANISH
        // Euskara
        "eu" -> Languages.SPANISH
        // Gallego
        "gl" -> Languages.SPANISH
        // Catalan
        "ca" -> Languages.SPANISH
        // Anything else, in english
        else -> Languages.ENGLISH
    }
    // Get the current UI Content
    val content = getContent(currentLanguage)
    // Make Sure Content Exists
    if (content == null) {
        Log.i(
            "${LanguageCoordinator.identifier}",
            "updateCurrentContent  ${DebuggingIdentifiers.actionOrEventFailed} Could not gather $currentLanguage file. Check that the context exists.",
        )
        return
    }
    // Set Content
    Log.i(
        "${LanguageCoordinator.identifier}",
        "updateCurrentContent  ${DebuggingIdentifiers.actionOrEventSucceded} Set content to $currentLanguage.",
    )
    currentContent = content
    // Send Notification
    NotificationCoordinator.shared.sendOnLanguageContentUpdateIntent()
}
