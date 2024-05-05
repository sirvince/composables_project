package com.example.composableproject.presentation.menu


import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.composableproject.R


@Composable
fun MenuScreen(
    navController: NavController,
){
    Box(
        modifier = Modifier
//            .background(Color.Magenta)
            .fillMaxSize()
    ) {
        Column {
            AccountHeaderSection(account = Account("John Vincent","Assistant Secretary"))
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_launcher_foreground,
                        Color.Blue,
                        Color.Blue,
                        Color.Blue,
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_launcher_foreground,
                        Color.Blue,
                        Color.Blue,
                        Color.Blue,
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_launcher_foreground,
                        Color.Blue,
                        Color.Blue,
                        Color.Blue,
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_launcher_foreground,
                        Color.Blue,
                        Color.Blue,
                        Color.Blue,
                    )
                )
            )
        }
    }

}