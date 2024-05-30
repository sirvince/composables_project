package com.example.composableproject.data.remote

import com.example.composableproject.BuildConfig
import com.example.composableproject.data.dto.ApiResponse
import com.example.composableproject.data.model.DataObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRepository {

    @GET("/users/getAllActiveUser")
    suspend fun fetchUserInfo() : Response<ApiResponse>



    @GET("/users/getAllActiveUserType")
    suspend fun fetchUserType() : Response<ApiResponse>



//    @GET(BuildConfig.ASC_BE +"/application/getone/{applicationId}")
//    suspend fun fetchApplication(
//        @Path("applicationId") applicationId : Int,
//    ) : Response<DataObject>


}