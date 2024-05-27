package com.example.composableproject.presentation.application.application_details.application_edit_menu

import androidx.annotation.DrawableRes

data class MultiFabItem(
    val id: Int,
    @DrawableRes val iconRes: Int,
    val label: String = ""
)