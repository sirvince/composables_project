package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class AssignedUserRole (

  @SerializedName("id"        ) var id        : Int?    = null,
  @SerializedName("type"      ) var type      : String? = null,
  @SerializedName("name"      ) var name      : String? = null,
  @SerializedName("status"    ) var status    : Int?    = null,
  @SerializedName("createdAt" ) var createdAt : String? = null,
  @SerializedName("updatedAt" ) var updatedAt : String? = null

)