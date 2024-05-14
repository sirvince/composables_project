package com.example.composableproject.presentation.application

data class Application(
    val id : Int,
    val formType : String,
    val referenceCode : String ,
    val applicationType : String,
    val brand : String,
    val product : String,
    val internalStatus : String,
    val releaseStatus : String,
//    val releaseStatus : Boolean? = true
){
    fun getBrandProduct() : String{
        return "$brand - $product"
    }
}
