package com.example.composableproject.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserType(
    @PrimaryKey val id: Int,
    val name: String?
)