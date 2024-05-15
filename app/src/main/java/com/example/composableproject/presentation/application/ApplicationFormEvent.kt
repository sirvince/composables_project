package com.example.composableproject.presentation.application

import android.content.Context
import com.example.composableproject.data.model.ApplicationFilterDto
import com.example.composableproject.data.model.LoginResponse


sealed class ApplicationFormEvent {

    data class GetApplication(val take : Int, val page: Int, val applicationFilterDto : ApplicationFilterDto): ApplicationFormEvent()


}