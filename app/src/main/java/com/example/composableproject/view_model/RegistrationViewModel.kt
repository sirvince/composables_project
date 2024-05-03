package com.example.composableproject.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composableproject.domain.use_case.validation.FieldFormat
import com.example.composableproject.domain.use_case.validation.ValidateAgreementTerm
import com.example.composableproject.domain.use_case.validation.ValidateInputField
import com.example.composableproject.state.sign_up.RegistrationFormEvent
import com.example.composableproject.state.sign_up.RegistrationFormState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val validateAgreementTerm : ValidateAgreementTerm = ValidateAgreementTerm(),
    private val validateInputField: ValidateInputField = ValidateInputField()
) : ViewModel() {

    var state by mutableStateOf(RegistrationFormState())
    private  val validationChannel  = Channel<ValidationEvent>()

    val validationEvents = validationChannel.receiveAsFlow()


    fun onEvent(event: RegistrationFormEvent){
        when(event){
            is RegistrationFormEvent.ValidateFirstName -> {
                state = state.copy(firstName =  event.firstName)
            }
            is RegistrationFormEvent.ValidateLastName -> {
                state = state.copy(lastName = event.lastName)
            }
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
            else -> {}
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
            textFormat = FieldFormat.EMAIL
        )

        val passwordResult = validateInputField.execute(
            state.password
        )

        val confirmPasswordResult = validateInputField.execute(
            state.password,
            confirmPassword = state.confirmPassword
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