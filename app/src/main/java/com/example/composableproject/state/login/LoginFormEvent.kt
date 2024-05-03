package com.example.composableproject.state.login


sealed class LoginFormEvent {

    data class LoginValidation(val username : String, val password: String): LoginFormEvent()
    data object Submit : LoginFormEvent()

}