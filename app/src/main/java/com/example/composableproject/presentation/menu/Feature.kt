package com.example.composableproject.presentation.menu

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.composableproject.ui.theme.PrimaryColor
import com.example.composableproject.ui.theme.SecondaryColor
import com.example.composableproject.ui.theme.TertiaryColor

data class Feature(
    val title: String,
    val destination: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color? =   TertiaryColor,
    val mediumColor: Color? = SecondaryColor,
    val darkColor: Color? = PrimaryColor
)