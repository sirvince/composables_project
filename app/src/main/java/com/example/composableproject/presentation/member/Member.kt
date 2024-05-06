package com.example.composableproject.presentation.member

data class Member(
    val id : Int,
    val firstName : String,
    val lastName : String,
    val contactNumber : String,
    val position : String? = "Member",
    val isActive : Boolean? = true
){
    fun getFullName() : String{
        return "$firstName $lastName"
    }
}
