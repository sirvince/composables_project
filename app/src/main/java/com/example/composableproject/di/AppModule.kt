package com.example.composableproject.di


import android.app.Application
import android.util.Log
import com.example.composableproject.database.SharedPreferencesManager
import com.example.composableproject.data.remote.ApplicationRepository
import com.example.composableproject.data.remote.ApplicationRepositoryImpl
import com.example.composableproject.data.remote.AuthRepository
import com.example.composableproject.data.remote.AuthRepositoryImpl
import com.example.composableproject.data.remote.LoginRepositoryImpl
import com.example.composableproject.data.remote.LoginRepository
import com.example.composableproject.data.remote.UserRepository
import com.example.composableproject.data.remote.UserRepositoryImpl
import com.example.composableproject.database.dao.UserDao
import com.example.composableproject.domain.use_case.ApplicationUseCase
import com.example.composableproject.domain.use_case.FetchUserInfoUseCase
import com.example.composableproject.domain.use_case.LoginUseCase
import com.example.composableproject.domain.use_case.validation.ValidateAgreementTerm
import com.example.composableproject.domain.use_case.validation.ValidateInputField
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {





    @Provides
    @Singleton
    fun provideSharedPreferencesManager( context: Application): SharedPreferencesManager {
        return SharedPreferencesManager(context)
    }

    @Provides
    @Singleton
    fun provideRetrofit(sharedPreferencesManager: SharedPreferencesManager): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        val token = sharedPreferencesManager.getToken()
        Log.v("LoginUseCase",token.toString())
        val authInterceptor = Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            requestBuilder.header("Authorization", "Bearer $token")
            val request = requestBuilder.build()
            chain.proceed(request)
        }

        val okHttpBuilder = OkHttpClient.Builder()
            . protocols(listOf(Protocol.HTTP_1_1))
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS)
            .followRedirects(false) // Disable automatic redirection
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authInterceptor) // Add the authorization interceptor
            .retryOnConnectionFailure(true)
            .build()


        return Retrofit.Builder()
//            .baseUrl(BuildConfig.BASE_URL)
//            .baseUrl("http://192.168.18.15:4300/")
            .baseUrl("http://192.168.1.24:4300/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpBuilder)
            .build()
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