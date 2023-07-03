package com.delasign.samplestarterproject.models.keys

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val sampleString = stringPreferencesKey("sampleStringPreferenceKey")
    val sampleInt = intPreferencesKey("sampleIntPreferenceKey")
    val sampleBoolean = booleanPreferencesKey("sampleBooleanPreferenceKey")
}
