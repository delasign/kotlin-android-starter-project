package com.delasign.samplestarterproject.coordinators.languageCoordinator

import android.content.Context
import android.util.Log
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import com.delasign.samplestarterproject.models.languageContent.Languages
import com.delasign.samplestarterproject.models.languageContent.UIContent
import java.util.Locale

class LanguageCoordinator {
    // MARK: Variables
    companion object {
        val shared = LanguageCoordinator()
        const val identifier = "[LanguageCoordinator]"
    }
    var systemLanguage: String = Locale.getDefault().language
    var currentLanguage: Languages = Languages.ENGLISH
    var context: Context? = null
    var currentContent: UIContent? = null

    // MARK: Lifecycle
    fun initialize(context: Context) {
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventInProgress} initialize  ${DebuggingIdentifiers.actionOrEventInProgress}.",
        )
        this.context = context
        updateCurrentContent()
    }
}
