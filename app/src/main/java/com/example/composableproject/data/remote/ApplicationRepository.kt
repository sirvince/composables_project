package com.example.composableproject.data.remote

import com.example.composableproject.BuildConfig
import com.example.composableproject.data.dto.CredentialDto
import com.example.composableproject.data.model.ApplicationFilterDto
import com.example.composableproject.data.model.LoginResponse
import com.example.composableproject.data.model.PaginationResponse
import com.example.composableproject.data.model.UserInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApplicationRepository {

    @POST(BuildConfig.ASC_USER +"/admin/view-all/pending-application")
    suspend fun pendingApplication(
        @Query("take") take : Int,
        @Query("page") page : Int,
        @Body applicationFilterDto: ApplicationFilterDto
    ) : Response<PaginationResponse>




}