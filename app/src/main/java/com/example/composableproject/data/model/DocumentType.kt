package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class DocumentType (

  @SerializedName("id"               ) var id             : Int?    = null,
  @SerializedName("type_of_document" ) var typeOfDocument : String? = null,
  @SerializedName("basis"            ) var basis          : String? = null,
  @SerializedName("variant"          ) var variant        : String? = null,
  @SerializedName("input"            ) var input          : String? = null,
  @SerializedName("remarks"          ) var remarks        : String? = null,
  @SerializedName("date_launch"      ) var dateLaunch     : String? = null,
  @SerializedName("expiration_date"  ) var expirationDate : String? = null,
  @SerializedName("created_at"       ) var createdAt      : String? = null,
  @SerializedName("updated_at"       ) var updatedAt      : String? = null,
  @SerializedName("deleted_at"       ) var deletedAt      : String? = null

)