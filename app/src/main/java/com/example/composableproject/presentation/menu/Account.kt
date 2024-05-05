package com.example.composableproject.presentation.menu

import androidx.compose.ui.graphics.vector.ImageVector

data class Account(
    val firstName : String,
    val role : String,
    val profile : ImageVector? = null
)
