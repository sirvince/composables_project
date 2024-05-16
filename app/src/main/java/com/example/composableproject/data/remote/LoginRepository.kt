package com.example.composableproject.data.remote

import com.example.composableproject.BuildConfig
import com.example.composableproject.data.dto.CredentialDto
import com.example.composableproject.data.dto.LoginResponse
import com.example.composableproject.data.model.UserInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginRepository {

    @POST(BuildConfig.ASC_BE +"/users/login")
    suspend fun login(@Body login: CredentialDto) : Response<LoginResponse>


    @GET(BuildConfig.ASC_BE +"/users/logged-in")
    suspend fun fetchUserDetails() : Response<UserInfo>

}