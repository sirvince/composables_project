package com.example.composableproject.screen

import AlternativeLoginOptions
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composableproject.R
import com.example.composableproject.component.HeaderText
import com.example.composableproject.component.InputTextField
import com.example.composableproject.route.Route
import com.example.composableproject.ui.theme.DEFAULT_PADDING
import com.example.composableproject.ui.theme.ITEM_SPACING

@Composable
fun LoginScreen(navController: NavController) {
    val ( userName , setUsername ) = rememberSaveable {
        mutableStateOf("")
    }
    val ( password , setPassword ) = rememberSaveable {
        mutableStateOf("")
    }
    val ( checked , onCheckedChange ) = rememberSaveable {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(DEFAULT_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HeaderText(
            text = "Login",
            modifier = Modifier
                .padding(vertical = DEFAULT_PADDING)
                .align(alignment = Alignment.Start)
        )

        InputTextField(
            value = userName,
            onValueChange = setUsername,
            labelText = stringResource(R.string.lbl_username),
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        InputTextField(
            value = password,
            onValueChange = setPassword,
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
            onClick = { navController.navigate(Route.SignUpScreen().name) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }


        AlternativeLoginOptions(
            onIconClick = {
                    index ->
                when(index){
                    0 -> {
                        Toast.makeText(context,"Soon", Toast.LENGTH_LONG).show()}
                    1 -> {
                        Toast.makeText(context,"Soon", Toast.LENGTH_LONG).show()}
                    2 -> {
                        Toast.makeText(context,"Soon", Toast.LENGTH_LONG).show()}
                }
            },
            onSignUpClick = {},
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.BottomCenter)
        )

    }
}