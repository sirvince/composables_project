package com.example.composableproject.presentation.menu


import com.example.composableproject.R
import com.example.composableproject.route.Route

object FeatureData {

    val FeatureList =  listOf(
        Feature(
            title = "Application",
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
}