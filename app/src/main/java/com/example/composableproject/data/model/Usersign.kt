package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class Usersign (

  @SerializedName("filename" ) var filename : String? = null,
  @SerializedName("sysname"  ) var sysname  : String? = null

)