package com.example.common.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

suspend fun Context.saveBoolean(key: String, value: Boolean){
    dataStore.edit { onboarding ->
        onboarding.set(key = booleanPreferencesKey(key), value)
    }
}

fun Context.getSharedValue(key: String): Flow<Boolean> {
    return dataStore.data.map { preferences ->
        return@map preferences[booleanPreferencesKey(key)] ?: false
    }
}