package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class TypeOfMedium (

  @SerializedName("id"              ) var id             : Int?    = null,
  @SerializedName("isMoving"        ) var isMoving       : Int?    = null,
  @SerializedName("type_of_medium"  ) var typeOfMedium   : String? = null,
  @SerializedName("dialect"         ) var dialect        : String? = null,
  @SerializedName("execution"       ) var execution      : String? = null,
  @SerializedName("lengthSize"      ) var lengthSize     : String? = null,
  @SerializedName("others"          ) var others         : String? = null,
  @SerializedName("main_doc"        ) var mainDoc        : String? = null,
  @SerializedName("clearance_type"  ) var clearanceType  : String? = null,
  @SerializedName("for_s1clearance" ) var forS1clearance : Int?    = null

)