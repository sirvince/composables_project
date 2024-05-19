package com.example.composableproject.presentation.application.application_list

import com.example.composableproject.data.model.ApplicationFilterDto


sealed class ApplicationDetailsFormEvent {

    data class GetApplicationDetails(val applicationId : Int): ApplicationDetailsFormEvent()


}