package com.example.composableproject.domain.use_case.validation

class ValidateAgreementTerm {

    fun execute(agreementIsAccept : Boolean) : ValidationResult {

        if(!agreementIsAccept){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Please check the agreement terms."
            )
        }

        return ValidationResult(isSuccessful = true)
    }
}