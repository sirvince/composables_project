package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class Usertype (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("type" ) var type : String? = null,
  @SerializedName("name" ) var name : String? = null

)