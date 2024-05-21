package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class Company (

  @SerializedName("id"          ) var id          : Int?    = null,
  @SerializedName("type"        ) var type        : String? = null,
  @SerializedName("name"        ) var name        : String? = null,
  @SerializedName("address"     ) var address     : String? = null,
  @SerializedName("tinno"       ) var tinno       : String? = null,
  @SerializedName("phone"       ) var phone       : String? = null,
  @SerializedName("mobile"      ) var mobile      : String? = null,
  @SerializedName("countryID"   ) var countryID   : Int?    = null,
  @SerializedName("contactID"   ) var contactID   : Int?    = null,
  @SerializedName("affiliateID" ) var affiliateID : Int?    = null,
  @SerializedName("affiliate" ) var affiliate : Affiliate?    = null,
  @SerializedName("status"      ) var status      : Int?    = null,
  @SerializedName("createdAt"   ) var createdAt   : String? = null,
  @SerializedName("updatedAt"   ) var updatedAt   : String? = null

)