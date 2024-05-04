package com.example.composableproject.data

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.example.composableproject.R
import com.example.composableproject.domain.use_case.respose.Response
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl (
    private val firebaseAuth: FirebaseAuth,
    private val appContext : Application
) : AuthRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("AuthRepositoryImpl $appName")

    }
    override fun loginUser(username: String, password: String): Flow<Response<AuthResult>> {
        return flow{
            emit(Response.Loading())
            val result = firebaseAuth.signInWithEmailAndPassword(username,password).await()
            emit(Response.Success(result))
        }.catch {
            Log.v("AuthRepositoryImpl",it.message.toString())
            emit(Response.Error(it.message.toString()))
        }
    }

    override fun registerUser(username: String, password: String): Flow<Response<AuthResult>> {
        return flow{
            emit(Response.Loading())
            val result = firebaseAuth.createUserWithEmailAndPassword(username,password).await()
            emit(Response.Success(result))
        }.catch {
            Log.v("AuthRepositoryImpl",it.message.toString())
            emit(Response.Error(it.message.toString()))
        }
    }
}