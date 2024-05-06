package com.example.composableproject.presentation.menu


import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.composableproject.R
import com.example.composableproject.route.Route
import com.example.composableproject.ui.theme.ITEM_SPACING
import com.example.composableproject.ui.theme.PrimaryColor
import com.example.composableproject.ui.theme.SecondaryColor
import com.example.composableproject.ui.theme.TertiaryColor


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
            Spacer(Modifier.height(ITEM_SPACING))
            AccountHeaderSection(account = Account("John Vincent","Assistant Secretary"))
            Spacer(Modifier.height(ITEM_SPACING))
            FeatureSection(navController,
                features = listOf(
                    Feature(
                        title = stringResource(R.string.member_list),
                        destination = Route.MemberListScreen().name,
                        R.drawable.ic_member
                    ),
                    Feature(
                        title = "Soon",
                        destination = Route.LoginScreen().name,
                        R.drawable.ic_launcher_foreground
                    ),
                    Feature(
                        title = "Soon",
                        destination = Route.LoginScreen().name,
                        R.drawable.ic_launcher_foreground
                    ),
                    Feature(
                        title = "Soon",
                        destination = Route.LoginScreen().name,
                        R.drawable.ic_launcher_foreground
                    )
                )
            )
        }
    }

}