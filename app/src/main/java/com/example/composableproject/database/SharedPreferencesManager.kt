package com.example.composableproject.database

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("asc_refs", Context.MODE_PRIVATE)

    companion object {
        private const val TOKEN_KEY = "token_key"
        private const val FIRST_LOGIN = "isFirstLogin"
    }

    // Function to save a token in SharedPreferences
    fun saveToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(TOKEN_KEY, token)
        editor.apply()
    }


    fun isFirstLogin(isFirstLogin: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(FIRST_LOGIN, isFirstLogin)
        editor.apply()
    }
    // Function to retrieve the token from SharedPreferences
    fun getToken(): String? {
        return sharedPreferences.getString(TOKEN_KEY, null)
    }

    fun isFirstLogin(): Boolean {
        return sharedPreferences.getBoolean(FIRST_LOGIN, false)
    }


    // Function to clear the token from SharedPreferences
    fun clearToken() {
        val editor = sharedPreferences.edit()
        editor.remove(TOKEN_KEY)
        editor.apply()
    }
}
