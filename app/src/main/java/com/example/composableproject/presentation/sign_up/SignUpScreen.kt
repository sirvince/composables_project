package com.example.composableproject.presentation.sign_up

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composableproject.R
import com.example.composableproject.component.HeaderText
import com.example.composableproject.component.InputTextField
import com.example.composableproject.route.Route
import com.example.composableproject.ui.theme.DEFAULT_PADDING
import com.example.composableproject.ui.theme.ITEM_SPACING
import com.example.composableproject.view_model.RegistrationViewModel

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: RegistrationViewModel = hiltViewModel()
){

    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect{ event ->
            when(event){
                is RegistrationViewModel.ValidationEvent.Success -> {
                    Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
                    navController.navigate(Route.LoginScreen().name)
                }
                is RegistrationViewModel.ValidationEvent.Loading -> {
                    Toast.makeText(context, "Loading...", Toast.LENGTH_LONG).show()
                }
                is RegistrationViewModel.ValidationEvent.Error -> {
                    Toast.makeText(context, event.errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
    }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(DEFAULT_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HeaderText(
            text = "Sign Up",
            modifier = Modifier
                .padding(vertical = DEFAULT_PADDING)
                .align(alignment = Alignment.Start)
        )

        InputTextField(
            value = state.firstName,
            onValueChange = { viewModel.onEvent(RegistrationFormEvent.ValidateFirstName(it)) },
            errorMessage = state.firstNameError,
            labelText = "First Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        InputTextField(
            value = state.lastName,
            onValueChange = {viewModel.onEvent(RegistrationFormEvent.ValidateLastName(it)) },
            errorMessage = state.lastNameError,
            labelText = "Last Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        InputTextField(
            value = state.email,
            onValueChange = {
                viewModel.onEvent(RegistrationFormEvent.EmailChanged(it))
            },
            errorMessage = state.emailError,
            labelText = "Email Address",
            leadingIcon = Icons.Default.Email,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        InputTextField(
            value = state.password,
            onValueChange = { viewModel.onEvent(RegistrationFormEvent.PasswordChanged(it)) },
            errorMessage = state.passwordError,
            labelText = stringResource(R.string.lbl_password),
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation =  PasswordVisualTransformation()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        InputTextField(
            value = state.confirmPassword,
            onValueChange = { viewModel.onEvent(RegistrationFormEvent.ConfirmPasswordChanged(it)) },
            errorMessage =  state.confirmPasswordError,
            labelText = "Confirm Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation =  PasswordVisualTransformation()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        Column {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val privacyText = "Privacy"
                val policyText = "Policy"
                val annotatedString = buildAnnotatedString {
                    withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)){
                        append("I agree with")
                    }
                    append(" ")
                    withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)){
                        pushStringAnnotation(tag = privacyText,privacyText)
                        append(privacyText)
                    }
                    append(" and ")
                    withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)){
                        pushStringAnnotation(tag = policyText,policyText)
                        append(policyText)
                    }
                }
                Checkbox(
                    checked = state.agreementTerm ,
                    onCheckedChange = { viewModel.onEvent(RegistrationFormEvent.Agreement(it)) }
                )
                ClickableText(
                    text = annotatedString,
                    style = MaterialTheme.typography.labelLarge,
                ){
                    offset -> annotatedString.getStringAnnotations(offset,offset).forEach {
                        when(it.tag){
                            privacyText -> navController.navigate(Route.PrivacyScreen().name)
                            policyText -> navController.navigate(Route.PrivacyScreen().name)
                        }
                    }
                }
            }

            if(!state.agreementTerm ){
                state.agreementError?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }

        Spacer(Modifier.height(ITEM_SPACING))

        Button(
            onClick = { viewModel.onEvent(RegistrationFormEvent.Submit)},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign Up")
        }


        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Already have an account?")
            Spacer(Modifier.height(ITEM_SPACING))
            TextButton(onClick = {
                navController.navigate(Route.LoginScreen().name)}
            ) {
                Text(text = "Sign in")
            }

        }



    }
}