package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class ApplicationFilterDto(

  @SerializedName("application_type") var applicationType: List<String> = arrayListOf(),
  @SerializedName("form_group") var formGroup: String? = null,
  @SerializedName("search") var search: String? = null,
  @SerializedName("process_type") var processType: String? = null,
  @SerializedName("form_type") var formType: String? = null

)