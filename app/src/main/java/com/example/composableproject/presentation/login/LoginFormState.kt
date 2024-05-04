package com.example.composableproject.presentation.login

data class LoginFormState (
    val username : String = "",
    val password : String = "",


    val usernameError : String? = null,
    val passwordError: String? = null
)