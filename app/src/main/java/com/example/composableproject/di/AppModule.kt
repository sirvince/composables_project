package com.example.composableproject.di


import android.app.Application
import android.util.Log
import com.example.composableproject.data.AuthRepository
import com.example.composableproject.data.AuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesRepositoryImpl(firebaseAuth: FirebaseAuth,appContext : Application) : AuthRepository {
        Log.v("AppModule","test")
        return AuthRepositoryImpl(firebaseAuth,appContext)
    }
}