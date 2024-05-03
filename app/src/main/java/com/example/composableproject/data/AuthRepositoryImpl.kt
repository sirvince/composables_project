package com.example.composableproject.data

import com.example.composableproject.domain.use_case.respose.Response
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl : AuthRepository {
    override fun loginUser(username: String, password: String): Flow<Response<AuthResult>> {
        TODO("Not yet implemented")
    }

    override fun registerUser(username: String, password: String): Flow<Response<AuthResult>> {
        TODO("Not yet implemented")
    }
}