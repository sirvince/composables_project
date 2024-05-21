package com.example.composableproject.presentation.application.application_list


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composableproject.data.model.DataObject
import com.example.composableproject.domain.use_case.ApplicationUseCase
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.example.composableproject.util.helper.LoggerUtil
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ApplicationDetailsViewModel @Inject constructor(
    private val  applicationUseCase: ApplicationUseCase
) : ViewModel() {

    private  val validationChannel  = Channel<ValidationEvent>()
    val validationEvents = validationChannel.receiveAsFlow()
    private val _agentsData : MutableStateFlow<DataObject> = MutableStateFlow(DataObject())
    val agentsData : StateFlow<DataObject> = _agentsData


    private fun onEvent(event: ApplicationDetailsFormEvent){
        when(event){
            is ApplicationDetailsFormEvent.GetApplicationDetails -> {
                getApplicationDetails(event.applicationId)
            }
        }
    }

    private fun getApplicationDetails(applicationId : Int) {
        viewModelScope.launch {

            LoggerUtil().logger("ApplicationDetailsScreen","viewModelScope.launch")
            validationChannel.send(ValidationEvent.Loading)
            when(val result = applicationUseCase.applicationDetails(applicationId)){
                is AppResponse.Error<*> -> {
                    result.message?.let {ValidationEvent.Error(it) }
                        ?.let { validationChannel.send(it) }

                    LoggerUtil().logger("ApplicationDetailsScreen","Error")

                }
                is AppResponse.Success<*> -> {
                    val data = Gson().fromJson(Gson().toJson(result.data),
                        DataObject::class.java)
                    _agentsData.value = data
                    LoggerUtil().logger("ApplicationDetailsScreen",Gson().toJson(_agentsData))
                    validationChannel.send(ValidationEvent.Success)
                }
                is AppResponse.Loading<*> -> {
                    validationChannel.send(ValidationEvent.Loading)
                    LoggerUtil().logger("ApplicationDetailsScreen","Loading")
                }
            }
        }
    }

    fun loadApplicationData(applicationId: Int) {
        onEvent(ApplicationDetailsFormEvent.GetApplicationDetails(applicationId))
    }

    sealed class ValidationEvent{
        data object Success : ValidationEvent()
        data object Loading : ValidationEvent()
        data class Error(val errorMessage: String) : ValidationEvent()
    }

}