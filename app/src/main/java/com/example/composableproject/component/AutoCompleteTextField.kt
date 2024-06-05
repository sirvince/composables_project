package com.example.composableproject.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoCompleteTextField() {
    var expanded by remember { mutableStateOf(false) }
    var textState by remember { mutableStateOf(TextFieldValue("")) }
    val options = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew")
    val filteredOptions = options.filter { it.contains(textState.text, ignoreCase = true) }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = textState,
            onValueChange = {
                textState = it
                expanded = it.text.isNotEmpty() && filteredOptions.isNotEmpty()
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text("Enter fruit") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            filteredOptions.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        textState = TextFieldValue(selectionOption)
                        expanded = false
                    }
                )
            }
        }
    }
}