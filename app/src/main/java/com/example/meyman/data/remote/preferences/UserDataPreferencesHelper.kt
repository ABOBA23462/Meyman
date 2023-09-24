package com.example.meyman.data.remote.preferences

import javax.inject.Inject

const val PREF_IS_AUTHORIZED = "is_authorized"
const val PREF_REFRESH_TOKEN: String = "refresh_token"
const val PREF_ACCESS_TOKEN: String = "access_token"
const val PREF_USER_EMAIL: String = "email"
const val KEY_FOR_USER_ID = "KEY_FOR_USER_ID"
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
        get() = preferences().getString(PREF_USER_EMAIL, "null")!!
        set(value) = preferences().edit().putString(PREF_USER_EMAIL, value).apply()

    var saveOnBoard : Boolean
        get() = preferences().getBoolean(PREF_ON_BOARD, false)
        set(value) = preferences().edit().putBoolean(PREF_ON_BOARD, value).apply()

    var userId : Int
        get() = preferences().getInt(KEY_FOR_USER_ID, 0)
        set(value) = preferences().edit().putInt(KEY_FOR_USER_ID, value).apply()

}