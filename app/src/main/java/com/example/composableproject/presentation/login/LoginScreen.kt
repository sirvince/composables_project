package com.example.composableproject.presentation.login

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composableproject.R
import com.example.composableproject.component.AlertDialogExample
import com.example.composableproject.component.InputTextField
import com.example.composableproject.component.LoadingDialog
import com.example.composableproject.route.Route
import com.example.composableproject.ui.theme.DEFAULT_PADDING
import com.example.composableproject.ui.theme.ITEM_SPACING

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val ( userName , setUsername ) = rememberSaveable {
        mutableStateOf("")
    }
    val ( password , setPassword ) = rememberSaveable {
        mutableStateOf("")
    }
    val ( checked , onCheckedChange ) = rememberSaveable {
        mutableStateOf(false)
    }

    var alertDialogState by remember { mutableStateOf(AlertDialogState()) }
    var isLoading by remember { mutableStateOf(false) }
    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect{ event ->
            when(event){
                LoginViewModel.ValidationEvent.Success -> {
                    isLoading = false
                    navController.navigate(Route.MenuScreen().name){
                        popUpTo(Route.LoginScreen().name){
                            inclusive = true
                        }
                    }


                    //connect again into api to get the information

                }
                LoginViewModel.ValidationEvent.Loading -> {
                    isLoading = true
                }
                is LoginViewModel.ValidationEvent.Error -> {
                    isLoading = false
                    alertDialogState = AlertDialogState(
                        showDialog = true,
                        title = "Login Failed!",
                        message = event.errorMessage
                    )
                }
            }
        }
    }

    if (isLoading) {
        LoadingDialog()
    }

    // Composable function for the AlertDialog
    if (alertDialogState.showDialog) {
        AlertDialogExample(
            onDismissRequest = {
                alertDialogState = alertDialogState.copy(showDialog = false)
            },
            onConfirmation = {
                alertDialogState = alertDialogState.copy(showDialog = false)
            },
            dialogTitle = alertDialogState.title,
            dialogText = alertDialogState.message,
            icon = Icons.Default.Info
        )
    }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(DEFAULT_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            modifier = Modifier.size(200.dp),
            contentDescription = "LOGO"
        )

        Text(
            text = "Login",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(4.dp)
        )

        InputTextField(
            value = userName,
            onValueChange = setUsername,
            errorMessage = state.usernameError,
            labelText = stringResource(R.string.lbl_username),
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        InputTextField(
            value = password,
            onValueChange = setPassword,
            errorMessage = state.passwordError,
            labelText = stringResource(R.string.lbl_password),
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation =  PasswordVisualTransformation()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = onCheckedChange
                )
                Text(text = "Remember me")
            }
            TextButton(
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Forgot Password")
            }
        }

        Spacer(Modifier.height(ITEM_SPACING))

        Button(
            onClick = { viewModel.onEvent(LoginFormEvent.LoginValidation(userName,password))},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }

}

