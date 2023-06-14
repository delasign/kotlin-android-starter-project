// ktlint-disable filename
package com.delasign.samplestarterproject.coordinators.languageCoordinator

import com.delasign.samplestarterproject.models.languageContent.Languages
import com.delasign.samplestarterproject.models.languageContent.UIContent
import com.delasign.samplestarterproject.utils.ReadJSONFromAssets
import com.google.gson.Gson

fun LanguageCoordinator.getContent(language: Languages): UIContent? {
    // Check that hte context exists
    val context = this.context ?: return null
    // Gather the language data
    val fileName = when (language) {
        Languages.SPANISH -> "es"
        else -> "en"
    }
    val jsonString = ReadJSONFromAssets(context, "strings/$fileName.json")
    // Make sure that there is data
    if (jsonString.isEmpty()) return null
    // Return Data as UIContent object
    return Gson().fromJson(jsonString, UIContent::class.java)
}
