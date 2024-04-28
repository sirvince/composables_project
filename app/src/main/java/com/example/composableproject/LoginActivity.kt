package com.example.composableproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composableproject.component.HeaderText
import com.example.composableproject.component.InputTextField
import com.example.composableproject.ui.theme.ComposableProjectTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

val defaultPadding = 16.dp
val itemSpacing = 8.dp
@Composable
fun LoginScreen() {
    val ( userName , setUsername ) = rememberSaveable {
        mutableStateOf("")
    }
    val ( password , setPassword ) = rememberSaveable {
        mutableStateOf("")
    }

    val ( checked , onCheckedChange ) = rememberSaveable {
        mutableStateOf(false)
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(defaultPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HeaderText(
            text = "Login",
            modifier = Modifier
                .padding(vertical = defaultPadding)
                .align(alignment = Alignment.Start)
        )

        InputTextField(
            value = userName,
            onValueChange = setUsername,
            labelText = stringResource(R.string.lbl_username),
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(itemSpacing))

        InputTextField(
            value = password,
            onValueChange = setPassword,
            labelText = stringResource(R.string.lbl_password),
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation =  PasswordVisualTransformation()
        )

        Spacer(Modifier.height(itemSpacing))
        
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

        Spacer(Modifier.height(itemSpacing))
        
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }


        AlternativeLoginOptions(
            onIconClick = {},
            onSignUpClick = {})

    }
}

@Composable
fun AlternativeLoginOptions(
    onIconClick : (index : Int) -> Unit,
    onSignUpClick : () -> Unit,
    modifier: Modifier = Modifier
){
   val iconList = listOf(
       R.drawable.ic_launcher_foreground,
       R.drawable.ic_launcher_foreground,
       R.drawable.ic_launcher_foreground
   )
    
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Text("or sign in with")
        Row(horizontalArrangement = Arrangement.SpaceEvenly){
            iconList.forEachIndexed{
                    index, iconResId ->
                Icon(
                    painter = painterResource(iconResId),
                    contentDescription = "Alternative Login",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { onIconClick(index) }
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(itemSpacing))
            }

        }
    }


    

}


@Preview(showSystemUi = true)
@Composable
fun LoginPreview() {
    ComposableProjectTheme {
        LoginScreen()
    }
}