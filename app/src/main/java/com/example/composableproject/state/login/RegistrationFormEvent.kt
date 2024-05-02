package com.example.composableproject.state.login

sealed class RegistrationFormEvent {
    data class ValidateFirstName(val firstName : String) : RegistrationFormEvent()
    data class ValidateLastName(val lastName : String) : RegistrationFormEvent()
    data class EmailChanged(val email : String) : RegistrationFormEvent()
    data class PasswordChanged(val password : String) : RegistrationFormEvent()
    data class ConfirmPasswordChanged(val confirmPassword: String) : RegistrationFormEvent()
    data class Agreement(val isAgree: Boolean) : RegistrationFormEvent()
    data object Submit : RegistrationFormEvent()
}
