package com.example.composableproject.view_model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composableproject.domain.use_case.LoginUseCase
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.example.composableproject.domain.use_case.validation.ValidateInputField
import com.example.composableproject.presentation.login.LoginFormEvent
import com.example.composableproject.presentation.login.LoginFormState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(
//    private val repository: AuthRepository,
    private val  loginUseCase: LoginUseCase,
    private val validateInputField: ValidateInputField = ValidateInputField()
) : ViewModel() {

//    private val _users = mutableStateOf<ValidationEvent<LoginResponse>>>(ValidationEvent.Loading)
//    val users: State<ApiState<List<User>>> = _users

    var state by mutableStateOf(LoginFormState())

    private  val validationChannel  = Channel<ValidationEvent>()

    val validationEvents = validationChannel.receiveAsFlow()

    fun onEvent(event: LoginFormEvent){
        when(event){
            is LoginFormEvent.LoginValidation -> {
                state = state.copy(username = event.username, password = event.password)
                onSubmitInformation(state.username  ,state.password)
            }

            LoginFormEvent.Submit -> {
//                onSubmitInformation()

            }
        }
    }

    private fun onSubmitInformation(username : String ,password : String) {
        val usernameResult = validateInputField.execute(username)
        val passwordResult = validateInputField.execute(password)

        val formHasError = listOf(
            usernameResult, passwordResult
        ).any {
            !it.isSuccessful
        }

        if (formHasError) {
            state = state.copy(
                usernameError = usernameResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )
            return
        }



        viewModelScope.launch {

            val result = loginUseCase.login(username,password)

            when(result){
                is AppResponse.Error<*> -> {
                    result.message?.let { ValidationEvent.Error(it) }
                        ?.let { validationChannel.send(it) }
                }
                is AppResponse.Success<*> -> {
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