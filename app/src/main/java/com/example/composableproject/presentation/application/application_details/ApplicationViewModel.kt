package com.example.composableproject.presentation.application.application_details


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class ApplicationViewModel @Inject constructor(
    private val  applicationUseCase: ApplicationUseCase
) : ViewModel() {

//    var state by mutableStateOf(LoginFormState())
    private  val validationChannel  = Channel<ValidationEvent>()
    val validationEvents = validationChannel.receiveAsFlow()

    private val _agentsData : MutableStateFlow<List<DataObject>> = MutableStateFlow(listOf())
    val agentsData : StateFlow<List<DataObject>> = _agentsData

    init {
//        val applicationFilter = ApplicationFilterDto(
//            applicationType = listOf("ALL"),
//            formGroup =  "ALL",
//            search = "",
//            processType = "ALL",
//            formType = "s1"
//        )
//        onEvent(ApplicationFormEvent.GetApplication(100,1,""))
    }

    fun onEvent(event: ApplicationFormEvent){
        when(event){
            is ApplicationFormEvent.GetApplication -> {
                getApplicationList(event)
            }
        }
    }

    fun clearAgentsData() {
        _agentsData.value = emptyList()
    }

    private fun getApplicationList(event : ApplicationFormEvent.GetApplication) {
        viewModelScope.launch {
            Log.v("vince","getApplicationList on Search ${event.search}")

            when(val result = applicationUseCase.application(event.take,event.page,event.search)){
                is AppResponse.Error<*> -> {
                    result.message?.let { ValidationEvent.Error(it) }
                        ?.let { validationChannel.send(it) }
                }
                is AppResponse.Success<*> -> {
                    val paginationResponse = Gson().fromJson(Gson().toJson(result.data),
                        PaginationResponse::class.java)
                    _agentsData.value = paginationResponse.data
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