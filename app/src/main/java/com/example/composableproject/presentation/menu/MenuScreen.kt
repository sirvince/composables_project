package com.example.composableproject.presentation.menu


import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composableproject.R
import com.example.composableproject.component.InputTextField
import com.example.composableproject.route.Route
import com.example.composableproject.ui.theme.ITEM_SPACING
import com.example.composableproject.ui.theme.PrimaryColor
import com.example.composableproject.ui.theme.SecondaryColor
import com.example.composableproject.ui.theme.TertiaryColor


@Composable
fun MenuScreen(
    navController: NavController,
){

    val ( search , setSearch ) = rememberSaveable {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
//            .background(Color.Magenta)
            .fillMaxSize()
    ) {
        Column {
            Spacer(Modifier.height(ITEM_SPACING))
            AccountHeaderSection(account = Account("John Vincent","Assistant Secretary"))
            Spacer(Modifier.height(ITEM_SPACING))
            //search
//            InputTextField(
//                value = search,
//                onValueChange = setSearch,
//                labelText = "Search reference code...",
//                leadingIcon = Icons.Default.Search,
//                modifier = Modifier.fillMaxWidth().padding(start=16.dp,end=16.dp)
//            )



            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ){

                Text(
                    text = "Monitoring",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

            }

            FeatureSection(navController,
                features = FeatureData.FeatureList
            )
        }
    }

}