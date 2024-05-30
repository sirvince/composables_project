package com.example.composableproject.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInfo(
    @PrimaryKey val id: Int,
    val fname: String?,
    val lname: String?,
    val user_type: Int?
)