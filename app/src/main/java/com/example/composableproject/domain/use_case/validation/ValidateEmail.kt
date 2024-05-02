package com.example.composableproject.domain.use_case.validation

import android.util.Patterns

class ValidateEmail {

    fun execute(email : String) : ValidationResult {
        if(email.isBlank()){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The emails can't be blank."
            )
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "That's not valid email."
            )
        }

        return ValidationResult(isSuccessful = true)
    }
}