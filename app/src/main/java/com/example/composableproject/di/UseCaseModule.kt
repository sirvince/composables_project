package com.example.composableproject.di

import com.example.composableproject.data.remote.ApplicationRepositoryImpl
import com.example.composableproject.data.remote.LoginRepositoryImpl
import com.example.composableproject.data.remote.UserRepositoryImpl
import com.example.composableproject.database.SharedPreferencesManager
import com.example.composableproject.domain.use_case.ApplicationUseCase
import com.example.composableproject.domain.use_case.FetchUserInfoUseCase
import com.example.composableproject.domain.use_case.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {


    @Provides
    fun provideLoginUseCase(loginRepository: LoginRepositoryImpl, sharedPreferencesManager: SharedPreferencesManager): LoginUseCase {
        return LoginUseCase(loginRepository,sharedPreferencesManager)
    }

    @Provides
    fun provideApplicationUseCase(applicationRepository: ApplicationRepositoryImpl): ApplicationUseCase {
        return ApplicationUseCase(applicationRepository)
    }


    @Provides
    fun provideUserInfoUseCase(userRepository: UserRepositoryImpl): FetchUserInfoUseCase {
        return FetchUserInfoUseCase(userRepository)
    }
}