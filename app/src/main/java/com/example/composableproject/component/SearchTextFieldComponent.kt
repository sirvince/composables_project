package com.example.composableproject.component



import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchInputTextField(
    modifier : Modifier = Modifier,
    value : String,
    onValueChange : (String) -> Unit,
    errorMessage : String? = null,
    labelText : String,
    leadingIcon : ImageVector? = null,
    keyboardType : KeyboardType = KeyboardType.Text,
    visualTransformation : VisualTransformation = VisualTransformation.None

){

    val (focusRequester) = FocusRequester.createRefs()

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        isError = errorMessage != null,
        label = {
            Text(labelText)
        },
        leadingIcon = {
            if(leadingIcon!=null)
                Icon( imageVector = leadingIcon,null )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(30),
        singleLine = true,
        keyboardActions = KeyboardActions(
            onDone = { focusRequester.requestFocus() }
        ),
    )

    if(errorMessage!=null){
        errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                modifier = modifier.padding(4.dp)
            )
        }
    }

}