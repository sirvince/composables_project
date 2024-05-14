package com.example.composableproject

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("asc_refs", Context.MODE_PRIVATE)

    companion object {
        private const val TOKEN_KEY = "token_key"
    }

    // Function to save a token in SharedPreferences
    fun saveToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(TOKEN_KEY, token)
        editor.apply()
    }

    // Function to retrieve the token from SharedPreferences
    fun getToken(): String? {
        return sharedPreferences.getString(TOKEN_KEY, null)
    }

    // Function to clear the token from SharedPreferences
    fun clearToken() {
        val editor = sharedPreferences.edit()
        editor.remove(TOKEN_KEY)
        editor.apply()
    }
}
