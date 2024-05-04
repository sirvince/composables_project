package com.example.composableproject.di


import android.app.Application
import android.util.Log
import com.example.composableproject.data.AuthRepository
import com.example.composableproject.data.AuthRepositoryImpl
import com.example.composableproject.domain.use_case.validation.ValidateAgreementTerm
import com.example.composableproject.domain.use_case.validation.ValidateInputField
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

    @Provides
    @Singleton
    fun validateInputField(): ValidateInputField {
        return ValidateInputField()
    }



    @Provides
    @Singleton
    fun validateAgreementTerm(): ValidateAgreementTerm {
        return ValidateAgreementTerm()
    }
}