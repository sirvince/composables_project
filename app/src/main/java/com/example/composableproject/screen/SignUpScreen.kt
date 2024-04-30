package com.example.composableproject.screen

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composableproject.R
import com.example.composableproject.component.HeaderText
import com.example.composableproject.component.InputTextField
import com.example.composableproject.route.Route
import com.example.composableproject.ui.theme.DEFAULT_PADDING
import com.example.composableproject.ui.theme.ITEM_SPACING

@Composable
fun SignUpScreen(navController: NavController){
    val ( firstName , onFirstNameChange ) = rememberSaveable {
        mutableStateOf("")
    }

    val ( lastName , onLastNameChange ) = rememberSaveable {
        mutableStateOf("")
    }

    val ( emailAddress , onEmailAddressChange ) = rememberSaveable {
        mutableStateOf("")
    }

    val ( userName , setUsername ) = rememberSaveable {
        mutableStateOf("")
    }

    val ( password , onPasswordChange ) = rememberSaveable {
        mutableStateOf("")
    }

    val ( confirmPassword , onConfirmPasswordChange ) = rememberSaveable {
        mutableStateOf("")
    }


    val ( agree , onAgreeChange ) = rememberSaveable {
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
            text = "Sign Up",
            modifier = Modifier
                .padding(vertical = DEFAULT_PADDING)
                .align(alignment = Alignment.Start)
        )

        InputTextField(
            value = firstName,
            onValueChange = onFirstNameChange,
            labelText = "First Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        InputTextField(
            value = lastName,
            onValueChange = onLastNameChange,
            labelText = "Last Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        InputTextField(
            value = emailAddress,
            onValueChange = onEmailAddressChange,
            labelText = "Email Address",
            leadingIcon = Icons.Default.Email,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        InputTextField(
            value = password,
            onValueChange = onPasswordChange,
            labelText = stringResource(R.string.lbl_password),
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation =  PasswordVisualTransformation()
        )

        Spacer(Modifier.height(ITEM_SPACING))

        InputTextField(
            value = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            labelText = "Confirm Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation =  PasswordVisualTransformation()
        )

        Spacer(Modifier.height(ITEM_SPACING))

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
            Checkbox(agree , onAgreeChange )
            ClickableText(text = annotatedString, style = MaterialTheme.typography.labelLarge){
                offset -> annotatedString.getStringAnnotations(offset,offset).forEach {
                    when(it.tag){
                        privacyText -> navController.navigate(Route.PrivacyScreen().name)
                        policyText -> navController.navigate(Route.PrivacyScreen().name)
                    }
                }
            }
        }

        Spacer(Modifier.height(ITEM_SPACING))

        Button(
            onClick = { Toast.makeText(context,"Register",Toast.LENGTH_LONG).show()},
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
            TextButton(onClick = { navController.navigate(Route.LoginScreen().name)}) {
                Text(text = "Sign in")
            }

        }



    }
}