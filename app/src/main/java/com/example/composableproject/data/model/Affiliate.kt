package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class Affiliate (
  @SerializedName("id"        ) var id        : Int?    = null,
  @SerializedName("name"      ) var name      : String? = null,
  @SerializedName("member"    ) var member    : Int?    = null,
  @SerializedName("status"    ) var status    : Int?    = null,

)