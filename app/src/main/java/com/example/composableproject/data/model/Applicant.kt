package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class Applicant(
    @SerializedName("id") val id: Int,
    @SerializedName("fname") val fname: String,
    @SerializedName("mname") val mname: String?,
    @SerializedName("lname") val lname: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("telNo") val telNo: String?,
    @SerializedName("altTelNo") val altTelNo: String?,
    @SerializedName("email") val email: String,
    @SerializedName("status") val status: Int,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String
)
