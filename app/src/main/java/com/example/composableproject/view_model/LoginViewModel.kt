package com.example.composableproject.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composableproject.domain.use_case.validation.ValidateInputField
import com.example.composableproject.state.login.LoginFormEvent
import com.example.composableproject.state.login.LoginFormState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
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
            validationChannel.send(ValidationEvent.Success)
        }

    }


    sealed class ValidationEvent{
        object Success : ValidationEvent()
    }

}