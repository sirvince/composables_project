package com.example.composableproject.domain.use_case.validation

data class ValidationResult (
    val isSuccessful : Boolean,
    val errorMessage : String? = null
)