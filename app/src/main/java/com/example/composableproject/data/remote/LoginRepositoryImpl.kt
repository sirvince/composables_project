package com.example.composableproject.data.remote

import android.util.Log
import com.example.composableproject.data.dto.CredentialDto
import com.example.composableproject.data.model.LoginResponse
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.tasks.await
import retrofit2.Response
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class LoginRepositoryImpl @Inject constructor (private val loginService : LoginService) : LoginService {


    override suspend fun login(login: CredentialDto) : Response<LoginResponse> {
        return loginService.login(login)

    }





}