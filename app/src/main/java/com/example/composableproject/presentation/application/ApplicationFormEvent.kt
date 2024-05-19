package com.example.composableproject.presentation.application

import com.example.composableproject.data.model.ApplicationFilterDto


sealed class ApplicationFormEvent {

    data class GetApplication(val take : Int, val page: Int, val search : String): ApplicationFormEvent()


}