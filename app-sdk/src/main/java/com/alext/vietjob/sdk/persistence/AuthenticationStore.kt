package com.alext.vietjob.sdk.persistence

import android.content.Context

class AuthenticationStore(context: Context) {

    private val sharedPref = context.getSharedPreferences(PREFERENCES_FILE, 0);

    var accessToken: String? = null
        get() {
            return sharedPref.getString(KEY_ACCESS_TOKEN, null)
        }
        set(value) {
            field = value
            sharedPref.edit().putString(KEY_ACCESS_TOKEN, value).apply()
        }

    fun clear() {
        accessToken = null
    }

    companion object {
        private const val PREFERENCES_FILE = "auth_credentials_store"
        private const val KEY_ACCESS_TOKEN = "access_token"
    }

}