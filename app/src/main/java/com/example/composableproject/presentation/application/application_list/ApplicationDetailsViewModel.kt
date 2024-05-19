package com.example.composableproject.presentation.application.application_list


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composableproject.data.model.ApplicationFilterDto
import com.example.composableproject.data.model.DataObject
import com.example.composableproject.data.dto.PaginationResponse
import com.example.composableproject.domain.use_case.ApplicationUseCase
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
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

    init {
        Log.v("vince","getApplicationDetails")
        onEvent(ApplicationDetailsFormEvent.GetApplicationDetails(260))
    }

    private fun onEvent(event: ApplicationDetailsFormEvent){
        when(event){
            is ApplicationDetailsFormEvent.GetApplicationDetails -> {
                getApplicationDetails(event.applicationId)
            }
        }
    }

    private fun getApplicationDetails(applicationId : Int) {
        viewModelScope.launch {
            Log.v("vince","getApplicationDetails")

            when(val result = applicationUseCase.applicationDetails(applicationId)){
                is AppResponse.Error<*> -> {
                    result.message?.let {ValidationEvent.Error(it) }
                        ?.let { validationChannel.send(it) }
                }
                is AppResponse.Success<*> -> {
                    val data = Gson().fromJson(Gson().toJson(result.data),
                        DataObject::class.java)
                    _agentsData.value = data
                    Log.v("getApplicationDetails",Gson().toJson(_agentsData))
                    validationChannel.send(ValidationEvent.Success)
                }
                is AppResponse.Loading<*> -> {
                    validationChannel.send(ValidationEvent.Loading)
                }
            }
        }
    }

    sealed class ValidationEvent{
        data object Success : ValidationEvent()
        data object Loading : ValidationEvent()
        data class Error(val errorMessage: String) : ValidationEvent()
    }

}