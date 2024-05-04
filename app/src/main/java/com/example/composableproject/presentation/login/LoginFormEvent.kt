package com.example.composableproject.presentation.login


sealed class LoginFormEvent {

    data class LoginValidation(val username : String, val password: String): LoginFormEvent()
    data object Submit : LoginFormEvent()

}