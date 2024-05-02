package com.example.composableproject.state.login

data class RegistrationFormState(
    val firstName : String = "",
    val lastName : String = "",
    val email : String = "",
    val password : String = "",
    val confirmPassword : String = "",
    val agreementTerm : Boolean = false,

    val firstNameError : String? = null,
    val lastNameError : String? = null,
    val emailError : String? = null,
    val passwordError : String? = null,
    val confirmPasswordError : String? = null,
    val agreementError : String? = null,

    val genericError : String? = null
)
