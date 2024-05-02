package com.example.composableproject.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.composableproject.component.HeaderText
import com.example.composableproject.ui.theme.DEFAULT_PADDING

@Composable
fun PrivacyScreen(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(DEFAULT_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HeaderText(text = "Privacy")
    }
}