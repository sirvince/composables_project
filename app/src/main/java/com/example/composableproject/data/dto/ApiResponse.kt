package com.example.composableproject.data.dto

import com.example.composableproject.data.model.DataObject
import com.google.gson.annotations.SerializedName
import java.util.Objects

data class ApiResponse(

    @SerializedName("status") var status  : String? = null,
    @SerializedName("message") var message : String? = null,
    @SerializedName("code") var code : Int? = null,
    @SerializedName("data") var data :  List<Any>,
)

