package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("status"  ) var status  : String? = null,
    @SerializedName("message" ) var message : String? = null,
    @SerializedName("email" ) var email : String? = null,
    @SerializedName("type" ) var type : String? = null,
    @SerializedName("token" ) var token : String? = null
)

