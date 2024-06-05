package com.example.composableproject.presentation.application.application_details


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composableproject.data.model.DataObject
import com.example.composableproject.data.dto.PaginationResponse
import com.example.composableproject.database.AppDatabase
import com.example.composableproject.database.dao.UserDao
import com.example.composableproject.database.entity.UserInfo
import com.example.composableproject.database.entity.UserType
import com.example.composableproject.domain.use_case.ApplicationUseCase
import com.example.composableproject.domain.use_case.FetchUserInfoUseCase
import com.example.composableproject.domain.use_case.FetchUserTypeUseCase
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.example.composableproject.util.helper.LoggerUtil
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
    private val  applicationUseCase: ApplicationUseCase,
    private val  fetchUserInfoUseCase: FetchUserInfoUseCase,
    private val  fetchUserTypeUseCase: FetchUserTypeUseCase,
) : ViewModel() {


    private  val validationChannel  = Channel<ValidationEvent>()
    val validationEvents = validationChannel.receiveAsFlow()

    private val _agentsData : MutableStateFlow<List<DataObject>> = MutableStateFlow(listOf())
    val agentsData : StateFlow<List<DataObject>> = _agentsData


    private val _userTypeData: MutableStateFlow<List<UserType>> = MutableStateFlow(listOf())
    val userTypeData : StateFlow<List<UserType>> = _userTypeData

    init {
        viewModelScope.launch {
//            fetchUserInfoUseCase.fetchUserInfo()
//            fetchUserTypeUseCase.fetchUserType()
            getUserType()
        }
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



    private fun getUserType() {
        viewModelScope.launch {

//            val result = fetchUserTypeUseCase.fetchUserTypeFromLocal()
//
//            LoggerUtil().logger("FetchUserTypeUseCase","fetchUserTypeFromLocal getUserType " , Gson().toJson(result))
////            _userTypeData.value = result as List<UserType>
            when(val result = fetchUserTypeUseCase.fetchUserTypeFromLocal()){
                is AppResponse.Error<*> -> {
                    result.message?.let { ValidationEvent.Error(it) }
                        ?.let { validationChannel.send(it) }
                }
                is AppResponse.Success<*> -> {
//                    val paginationResponse = Gson().fromJson(Gson().toJson(result.data),
//                        PaginationResponse::class.java)
                    _userTypeData.value = result.data as List<UserType>
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