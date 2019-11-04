package com.julienarzul.kotlinmultiplatform.sample.androidapp

import android.content.SharedPreferences
import devfest.domain.KeyValueStorage

class SharedPreferencesStorage(private val sharedPreferences: SharedPreferences) : KeyValueStorage {

    override fun storeString(key: String, value: String) {
        sharedPreferences.edit()
            .putString(key, value)
            .apply()
    }

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
}