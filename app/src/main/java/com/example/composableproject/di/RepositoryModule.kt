package com.example.composableproject.di

import android.app.Application
import com.example.composableproject.data.remote.ApplicationRepository
import com.example.composableproject.data.remote.AuthRepository
import com.example.composableproject.data.remote.AuthRepositoryImpl
import com.example.composableproject.data.remote.LoginRepository
import com.example.composableproject.data.remote.UserRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesRepositoryImpl(firebaseAuth: FirebaseAuth,appContext : Application) : AuthRepository {
        return AuthRepositoryImpl(firebaseAuth,appContext)
    }

    @Provides
    @Singleton
    fun providesLoginService(retrofit: Retrofit) : LoginRepository {
        return retrofit.create(LoginRepository::class.java)
    }


    @Provides
    @Singleton
    fun providesApplicationService(retrofit: Retrofit) : ApplicationRepository {
        return retrofit.create(ApplicationRepository::class.java)
    }


    @Provides
    @Singleton
    fun providesUserService(retrofit: Retrofit) : UserRepository {
        return retrofit.create(UserRepository::class.java)
    }
}