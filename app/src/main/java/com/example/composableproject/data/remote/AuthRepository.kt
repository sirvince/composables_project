package com.example.composableproject.data.remote

import com.example.composableproject.domain.use_case.respose.AppResponse
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(username : String, password : String ) : Flow<AppResponse<AuthResult>>
    fun registerUser(username: String, password: String ) : Flow<AppResponse<AuthResult>>

}