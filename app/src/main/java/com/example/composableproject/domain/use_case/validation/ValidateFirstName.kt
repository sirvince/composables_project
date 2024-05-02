package com.example.composableproject.domain.use_case.validation


class ValidateFirstName {

    fun execute(
        firstName:String
    ) : ValidationResult {

        if(firstName.isBlank()){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "This $firstName can't be empty."
            )
        }

        return ValidationResult(isSuccessful = true)
    }



}

