package com.example.composableproject.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composableproject.data.dto.LoginResponse
import com.example.composableproject.domain.use_case.LoginUseCase
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.example.composableproject.domain.use_case.validation.FieldFormat
import com.example.composableproject.domain.use_case.validation.ValidateInputField
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val  loginUseCase: LoginUseCase,
    private val validateInputField: ValidateInputField = ValidateInputField()
) : ViewModel() {

    var state by mutableStateOf(LoginFormState())
    private  val validationChannel  = Channel<ValidationEvent>()
    val validationEvents = validationChannel.receiveAsFlow()

    fun onEvent(event: LoginFormEvent){
        when(event){
            is LoginFormEvent.LoginValidation -> {
                state = state.copy(username = event.username, password = event.password)
                onSubmitInformation(state.username  ,state.password)
            }

        }
    }

    private fun onSubmitInformation(username : String ,password : String) {
        val usernameResult = validateInputField.execute(username,textFormat = FieldFormat.EMAIL)
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
        }else{
            state = state.copy(
                usernameError = usernameResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )
        }


        viewModelScope.launch {
            validationChannel.send(ValidationEvent.Loading)
            when(val result = loginUseCase.login(username,password)){
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


    private fun onFetchInformation(loginResponse: LoginResponse) {
        viewModelScope.launch {

        }

    }

    sealed class ValidationEvent{
        data object Success : ValidationEvent()
        data object Loading : ValidationEvent()
        data class Error(val errorMessage: String) : ValidationEvent()
    }

}