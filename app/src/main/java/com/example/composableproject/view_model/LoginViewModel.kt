package com.example.composableproject.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composableproject.data.AuthRepository
import com.example.composableproject.data.AuthRepositoryImpl
import com.example.composableproject.domain.use_case.respose.Response
import com.example.composableproject.domain.use_case.validation.ValidateInputField
import com.example.composableproject.state.login.LoginFormEvent
import com.example.composableproject.state.login.LoginFormState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
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
//        val usernameResult = validateInputField.execute(username)
//        val passwordResult = validateInputField.execute(password)

        val usernameResult = username
        val passwordResult = password

//        val formHasError = listOf(
//            usernameResult, passwordResult
//        ).any {
//            !it.isSuccessful
//        }

//        if (formHasError) {
//            state = state.copy(
//                usernameError = usernameResult.errorMessage,
//                passwordError = passwordResult.errorMessage
//            )
//            return
//        }

        viewModelScope.launch {
            repository.registerUser(username,password).collect{result ->
                when(result){
                    is Response.Error -> {

//                        validationChannel.send(ValidationEvent.Success)
                        validationChannel.send(ValidationEvent.Error)
                    }
                    is Response.Loading -> {
                        validationChannel.send(ValidationEvent.Loading)

                    }
                    is Response.Success -> {
                        validationChannel.send(ValidationEvent.Success)

                    }
                }

            }

        }

    }


    sealed class ValidationEvent{
        data object Success : ValidationEvent()
        data object Loading : ValidationEvent()
        data object Error: ValidationEvent()
    }

}