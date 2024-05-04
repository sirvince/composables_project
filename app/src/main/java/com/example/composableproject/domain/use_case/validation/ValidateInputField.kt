package com.example.composableproject.domain.use_case.validation

import android.util.Patterns


class ValidateInputField {

    private val minimumLength  = 8

    fun execute(
        text : String,
        isMandatory: Boolean? = true,
        confirmPassword : String? = null,
        textFormat : FieldFormat? = null,
        minLength : Int? = minimumLength
    ) : ValidationResult {

        if(isMandatory == true){
            if(text.trim().isBlank()){
                return ValidationResult(
                    isSuccessful = false,
                    errorMessage = "This field can't be empty."
                )
            }
        }

        if(text.length < minLength!!){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The field needs to consist of at least $minLength characters"
            )
        }

        if(confirmPassword != null){
            if(text != confirmPassword){
                return ValidationResult(
                    isSuccessful = false,
                    errorMessage = "The confirm password don't match to password"
                )
            }
        }


        if(textFormat!=null){
            when(textFormat){
                FieldFormat.EMAIL-> {
                    if(!Patterns.EMAIL_ADDRESS.matcher(text.trim()).matches()){
                        return ValidationResult(
                            isSuccessful = false,
                            errorMessage = "This field is not valid email."
                        )
                    }
                }
                FieldFormat.CONTAINS_LETTER_AND_DIGIT ->{
                    val containsLetterAndDigits = text.trim().any { it.isDigit() } && text.trim().any { it.isLetter()}
                    if(!containsLetterAndDigits){
                        return ValidationResult(
                            isSuccessful = false,
                            errorMessage = "This field needs to contain at least one letter and digits"
                        )
                    }
                }
                FieldFormat.NAME -> {
                   //name pattern
                }
            }
        }

        return ValidationResult(isSuccessful = true)
    }



}

