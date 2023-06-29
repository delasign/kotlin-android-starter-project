// ktlint-disable filename
package com.delasign.samplestarterproject.coordinators.dataCoordinator

import android.util.Log
import androidx.datastore.preferences.core.edit
import com.delasign.samplestarterproject.coordinators.languageCoordinator.LanguageCoordinator.Companion.identifier
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import com.delasign.samplestarterproject.models.keys.PreferencesKeys
import kotlinx.coroutines.flow.firstOrNull

// MARK: Sample String Functionality
// Please note that the DataStore functionality must be called within a couroutine.
suspend fun DataCoordinator.getSampleStringDataStore(): String {
    val context = this.context ?: return defaultSampleStringPreferenceValue
    return context.dataStore.data.firstOrNull()?.get(PreferencesKeys.sampleString)
        ?: defaultSampleStringPreferenceValue
}

suspend fun DataCoordinator.setSampleStringDataStore(value: String) {
    val context = this.context ?: return
    Log.i(
        identifier,
        "${DebuggingIdentifiers.actionOrEventInProgress} setSampleDataStore  ${DebuggingIdentifiers.actionOrEventInProgress}."
    )
    context.dataStore.edit { preferences ->
        preferences[PreferencesKeys.sampleString] = value
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventInProgress} setSampleDataStore  ${DebuggingIdentifiers.actionOrEventSucceded} sample string : $value."
        )
    }
}

// MARK: Sample Int Functionality
// Please note that the DataStore functionality must be called within a couroutine.
suspend fun DataCoordinator.getSampleIntDataStore(): Int {
    val context = this.context ?: return defaultSampleIntPreferenceVariable
    return context.dataStore.data.firstOrNull()?.get(PreferencesKeys.sampleInt)
        ?: defaultSampleIntPreferenceVariable
}

suspend fun DataCoordinator.setSampleIntDataStore(value: Int) {
    val context = this.context ?: return
    Log.i(
        identifier,
        "${DebuggingIdentifiers.actionOrEventInProgress} setSampleIntDataStore  ${DebuggingIdentifiers.actionOrEventInProgress}."
    )
    context.dataStore.edit { preferences ->
        preferences[PreferencesKeys.sampleInt] = value
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventInProgress} setSampleIntDataStore  ${DebuggingIdentifiers.actionOrEventSucceded} sample int : $value."
        )
    }
}

// MARK: Sample Boolean Functionality
// Please note that the DataStore functionality must be called within a couroutine.
suspend fun DataCoordinator.getSampleBooleanDataStore(): Boolean {
    val context = this.context ?: return defaultSampleBooleanPreferenceVariable
    return context.dataStore.data.firstOrNull()?.get(PreferencesKeys.sampleBoolean)
        ?: defaultSampleBooleanPreferenceVariable
}

suspend fun DataCoordinator.setSampleBooleanDataStore(value: Boolean) {
    val context = this.context ?: return
    Log.i(
        identifier,
        "${DebuggingIdentifiers.actionOrEventInProgress} setSampleBooleanDataStore  ${DebuggingIdentifiers.actionOrEventInProgress}."
    )
    context.dataStore.edit { preferences ->
        preferences[PreferencesKeys.sampleBoolean] = value
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventInProgress} setSampleBooleanDataStore  ${DebuggingIdentifiers.actionOrEventSucceded} sample boolean : $value."
        )
    }
}