package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class UserInfo (

  @SerializedName("id"       ) var id       : Int?      = null,
  @SerializedName("typeId"   ) var typeId   : Int?      = null,
  @SerializedName("fname"    ) var fname    : String?   = null,
  @SerializedName("lname"    ) var lname    : String?   = null,
  @SerializedName("mname"    ) var mname    : String?   = null,
  @SerializedName("phone"    ) var phone    : String?   = null,
  @SerializedName("telNo"    ) var telNo    : String?   = null,
  @SerializedName("altTelNo" ) var altTelNo : String?   = null,
  @SerializedName("email"    ) var email    : String?   = null,
  @SerializedName("passtemp" ) var passtemp : String?   = null,
  @SerializedName("status"   ) var status   : Int?      = null,
  @SerializedName("usertype" ) var usertype : Usertype? = Usertype(),
  @SerializedName("usersign" ) var usersign : Usersign? = Usersign()

)