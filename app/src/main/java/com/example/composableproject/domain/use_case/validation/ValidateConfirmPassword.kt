package com.example.composableproject.domain.use_case.validation

class ValidateConfirmPassword {

    fun execute(password : String, confirmPassword: String) : ValidationResult {

        if(password != confirmPassword){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The confirm password don't match to password"
            )
        }

        return ValidationResult(isSuccessful = true)
    }
}