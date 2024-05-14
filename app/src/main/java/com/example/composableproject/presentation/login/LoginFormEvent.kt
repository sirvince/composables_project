package com.example.composableproject.presentation.login

import android.content.Context
import com.example.composableproject.data.model.LoginResponse


sealed class LoginFormEvent {

    data class LoginValidation(val username : String, val password: String): LoginFormEvent()


}