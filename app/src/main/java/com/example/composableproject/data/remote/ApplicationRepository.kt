package com.example.composableproject.data.remote

import com.example.composableproject.BuildConfig
import com.example.composableproject.data.model.ApplicationFilterDto
import com.example.composableproject.data.dto.PaginationResponse
import com.example.composableproject.data.model.DataObject
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApplicationRepository {

    @GET(BuildConfig.ASC_BE +"/application/search")
    suspend fun pendingApplication(
        @Query("size") take : Int,
        @Query("page") page : Int,
        @Query("search") search : String
    ) : Response<PaginationResponse>



    @GET(BuildConfig.ASC_BE +"/application/getone/{applicationId}")
    suspend fun fetchApplication(
        @Path("applicationId") applicationId : Int,
    ) : Response<DataObject>


}