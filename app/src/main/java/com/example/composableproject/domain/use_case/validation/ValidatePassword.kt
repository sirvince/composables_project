package com.example.composableproject.domain.use_case.validation

class ValidatePassword {

    fun execute(password : String) : ValidationResult {
        val MIN_LENGTH  = 8

        if(password.isBlank()){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The password can't be blank."
            )
        }

        if(password.length < MIN_LENGTH){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The password needs to consist of at least $MIN_LENGTH characters"
            )
        }

        val containsLetterAndDigits = password.any { it.isDigit() } && password.any { it.isLetter()}

        if(!containsLetterAndDigits){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The password needs to contain at least one letter and digits"
            )
        }
         
        return ValidationResult(isSuccessful = true)
    }
}