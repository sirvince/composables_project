package com.example.composableproject.domain.use_case

import android.content.Context
import android.util.Log
import com.example.composableproject.SharedPreferencesManager
import com.example.composableproject.data.dto.CredentialDto
import com.example.composableproject.data.model.LoginResponse
import com.example.composableproject.data.model.UserInfo
import com.example.composableproject.data.remote.LoginRepositoryImpl
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.google.gson.Gson
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepositoryImpl,
    private val sharedPreferencesManager: SharedPreferencesManager
) {

    suspend fun login ( username: String, password: String): Any {
        return try {
            val credentialDto = CredentialDto(username, password)
            val response = loginRepository.login(credentialDto)
            if (response.isSuccessful) {
                sharedPreferencesManager.saveToken(response.body()?.token.toString())
                val userDetailResponse = loginRepository.fetchUserDetails()
                if(userDetailResponse.isSuccessful){
                    val userResponse =  userDetailResponse.body()
                    AppResponse.Success(userResponse)
                }else{
                    val errorBody = userDetailResponse.errorBody()?.string()
                    val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
                    AppResponse.Error(errorResponse.message.toString(),"Failed",)
                }
            } else {
                val errorBody = response.errorBody()?.string()
                val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
                AppResponse.Error(errorResponse.message.toString(),"Failed",)
            }
        } catch (e: Exception) {
            AppResponse.Error(e.localizedMessage,"Exception")
        }
    }
}
