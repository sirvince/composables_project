package com.example.composableproject.data.remote

import com.example.composableproject.data.dto.CredentialDto
import com.example.composableproject.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("users/login")
    suspend fun login(@Body login: CredentialDto) : Response<LoginResponse>

}