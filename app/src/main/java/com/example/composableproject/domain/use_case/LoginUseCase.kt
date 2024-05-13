package com.example.composableproject.domain.use_case

import com.example.composableproject.data.dto.CredentialDto
import com.example.composableproject.data.model.LoginResponse
import com.example.composableproject.data.remote.LoginRepositoryImpl
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.google.gson.Gson
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepositoryImpl) {

    suspend fun login (username: String, password: String): Any {
        try {
            val credentialDto = CredentialDto(username, password)
            val response = loginRepository.login(credentialDto)
            if (response.isSuccessful) {
                val loginResponse = response.body()
                return AppResponse.Success(loginResponse)
            } else {
                val errorBody = response.errorBody()?.string()
                val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
                return AppResponse.Error(errorResponse.message.toString(),"Failed",)
            }
        } catch (e: Exception) {
            return AppResponse.Error("Exception",e.message)
        }
    }

}
