package com.example.composableproject.data.remote

import com.example.composableproject.data.dto.CredentialDto
import com.example.composableproject.data.dto.LoginResponse
import com.example.composableproject.data.model.UserInfo
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor (private val loginRepository : LoginRepository) : LoginRepository {


    override suspend fun login(login: CredentialDto) : Response<LoginResponse> {
        return loginRepository.login(login)

    }

    override suspend fun fetchUserDetails(): Response<UserInfo> {
        return loginRepository.fetchUserDetails()
    }


}