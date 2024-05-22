package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class AssignedUser (

  @SerializedName("id"        ) var id        : Int?    = null,
  @SerializedName("fname"     ) var fname     : String? = null,
  @SerializedName("mname"     ) var mname     : String? = null,
  @SerializedName("lname"     ) var lname     : String? = null,
  @SerializedName("phone"     ) var phone     : String? = null,
  @SerializedName("telNo"     ) var telNo     : String? = null,
  @SerializedName("altTelNo"  ) var altTelNo  : String? = null,
  @SerializedName("email"     ) var email     : String? = null,
  @SerializedName("status"    ) var status    : Int?    = null,
  @SerializedName("createdAt" ) var createdAt : String? = null,
  @SerializedName("updatedAt" ) var updatedAt : String? = null,
  @SerializedName("user_type" ) var user_type : Usertype? = null

)