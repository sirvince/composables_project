package com.example.composableproject.view_model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composableproject.domain.use_case.validation.FIELD_FORMAT
import com.example.composableproject.domain.use_case.validation.ValidateAgreementTerm
import com.example.composableproject.domain.use_case.validation.ValidateConfirmPassword
import com.example.composableproject.domain.use_case.validation.ValidateEmail
import com.example.composableproject.domain.use_case.validation.ValidateInputField
import com.example.composableproject.domain.use_case.validation.ValidatePassword
import com.example.composableproject.state.login.RegistrationFormEvent
import com.example.composableproject.state.login.RegistrationFormState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateConfirmPassword: ValidateConfirmPassword = ValidateConfirmPassword(),
    private val validateAgreementTerm : ValidateAgreementTerm = ValidateAgreementTerm(),
    private val validateInputField: ValidateInputField = ValidateInputField()
) : ViewModel() {

    var state by mutableStateOf(RegistrationFormState())
    private  val validationChannel  = Channel<ValidationEvent>()

    val validationEvents = validationChannel.receiveAsFlow()


    fun onEvent(event: RegistrationFormEvent){
       Log.v("onEvent TEST ",event.toString())
        when(event){

//            is RegistrationFormEvent.ValidateInputField -> {
//                state = state.copy(event.firstName)
//            }
            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is RegistrationFormEvent.ConfirmPasswordChanged -> {
                state = state.copy(confirmPassword = event.confirmPassword)
            }
            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is RegistrationFormEvent.Agreement -> {
                state = state.copy(agreementTerm = event.isAgree)
            }
            is RegistrationFormEvent.Submit -> {
                submitData()
            }

            is RegistrationFormEvent.ValidateFirstName -> {
                state = state.copy(firstName =  event.firstName)
            }

            is RegistrationFormEvent.ValidateLastName -> {

                state = state.copy(lastName = event.lastName)
            }

        }
    }

    private fun submitData() {
        val firstNameResult = validateInputField.execute(
            state.firstName
        )

        val lastNameResult = validateInputField.execute(
            state.lastName,
        )

        val emailResult = validateInputField.execute(
            state.email,
            format = FIELD_FORMAT.EMAIL.toString()
        )

        val passwordResult = validateInputField.execute(
            state.password
        )

        val confirmPasswordResult = validateConfirmPassword.execute(
            state.password,
            state.confirmPassword
        )
        val agreementTermResult = validateAgreementTerm.execute(state.agreementTerm)


        val formHasError = listOf(
            lastNameResult,
            firstNameResult,
            emailResult,
            passwordResult,
            confirmPasswordResult,
            agreementTermResult

        ).any{
            !it.isSuccessful
        }
        if(formHasError){
            state = state.copy(
                firstNameError =  firstNameResult.errorMessage,
                lastNameError =  lastNameResult.errorMessage,
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                confirmPasswordError =  confirmPasswordResult.errorMessage,
                agreementError = agreementTermResult.errorMessage
            )
            return
        }

        viewModelScope.launch {
            validationChannel.send(ValidationEvent.Success)
        }
    }


    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }
}