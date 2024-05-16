package com.example.composableproject.data.dto

import com.example.composableproject.data.model.DataObject
import com.google.gson.annotations.SerializedName

data class PaginationResponse (

  @SerializedName("data") val data: List<DataObject>,
  @SerializedName("count") val count: Int,
  @SerializedName("perPage") val perPage: Int,
  @SerializedName("currentPage") val currentPage: Int,
  @SerializedName("nextPage") val nextPage: Int?,
  @SerializedName("prevPage") val prevPage: String?,
  @SerializedName("lastPage") val lastPage: Int

)