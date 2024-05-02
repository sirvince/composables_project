package com.example.composableproject.domain.use_case.validation

import android.health.connect.datatypes.units.Length
import android.util.Patterns


class ValidateInputField {

    private val minimumLength  = 8

    fun execute(
        fieldName : String,
        isNotEmpty: Boolean? = true,
        format : String? = null,
        minLength : Int? = minimumLength
    ) : ValidationResult {

        if(isNotEmpty == true){
            if(fieldName.isBlank()){
                return ValidationResult(
                    isSuccessful = false,
                    errorMessage = "This field can't be empty."
                )
            }
        }


        if(fieldName.length < minLength!!){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The field needs to consist of at least $minLength characters"
            )
        }


        if(format!=null){
            when(format){
                FIELD_FORMAT.EMAIL.toString() -> {
                    if(!Patterns.EMAIL_ADDRESS.matcher(fieldName).matches()){
                        return ValidationResult(
                            isSuccessful = false,
                            errorMessage = "This field is not valid email."
                        )
                    }
                }
                FIELD_FORMAT.CONTAINS_LETTER_AND_DIGIT.toString() ->{
                    val containsLetterAndDigits = fieldName.any { it.isDigit() } && fieldName.any { it.isLetter()}
                    if(!containsLetterAndDigits){
                        return ValidationResult(
                            isSuccessful = false,
                            errorMessage = "This field needs to contain at least one letter and digits"
                        )
                    }
                }
            }
        }

        return ValidationResult(isSuccessful = true)
    }



}

