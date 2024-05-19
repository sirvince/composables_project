package com.example.composableproject.data.dto

import com.example.composableproject.data.model.DataObject
import com.google.gson.annotations.SerializedName

data class PaginationResponse (

  @SerializedName("rows") val data: List<DataObject>,
  @SerializedName("count") val count: Int,
  @SerializedName("cpage") val perPage: Int,
  @SerializedName("tpage") val currentPage: Int,
//  @SerializedName("nextPage") val nextPage: Int?,
//  @SerializedName("prevPage") val prevPage: String?,
//  @SerializedName("lastPage") val lastPage: Int

)