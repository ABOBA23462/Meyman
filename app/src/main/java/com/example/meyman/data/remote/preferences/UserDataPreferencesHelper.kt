package com.example.meyman.data.remote.preferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

const val PREF_IS_AUTHORIZED = "is_authorized"
const val PREF_REFRESH_TOKEN: String = "refresh_token"
const val PREF_ACCESS_TOKEN: String = "access_token"
const val PREF_USER_EMAIL: String = "email"
const val PREF_ON_BOARD = "on_board"

class UserDataPreferencesHelper @Inject constructor(
    private val preferences: PreferenceHelper
) {
    var isAuthorized : Boolean
        get() = preferences().getBoolean(PREF_IS_AUTHORIZED, false)
        set(value) = preferences().edit().putBoolean(PREF_IS_AUTHORIZED, value).apply()

    var refreshToken : String
        get() = preferences().getString(PREF_REFRESH_TOKEN, "null")!!
        set(value) = preferences().edit().putString(PREF_REFRESH_TOKEN, value).apply()

    var accessToken : String
        get() = preferences().getString(PREF_ACCESS_TOKEN, "null")!!
        set(value) = preferences().edit().putString(PREF_ACCESS_TOKEN, value).apply()

    var userEmail : String
        get() = preferences().getString(PREF_ACCESS_TOKEN, "null")!!
        set(value) = preferences().edit().putString(PREF_ACCESS_TOKEN, value).apply()

    var saveOnBoard : Boolean
        get() = preferences().getBoolean(PREF_ON_BOARD, false)
        set(value) = preferences().edit().putBoolean(PREF_ON_BOARD, value).apply()
}