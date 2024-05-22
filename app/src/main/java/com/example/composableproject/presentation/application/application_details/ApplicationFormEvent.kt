package com.example.composableproject.presentation.application.application_details


sealed class ApplicationFormEvent {

    data class GetApplication(val take : Int, val page: Int, val search : String): ApplicationFormEvent()


}