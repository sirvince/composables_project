package com.example.composableproject.data.remote

import android.util.Log
import com.example.composableproject.data.model.ApplicationFilterDto
import com.example.composableproject.data.model.PaginationResponse
import retrofit2.Response
import javax.inject.Inject

class ApplicationRepositoryImpl @Inject constructor( private val applicationRepository: ApplicationRepository) : ApplicationRepository {


    override suspend fun pendingApplication(
        take: Int,
        page: Int,
        applicationFilterDto: ApplicationFilterDto
    ): Response<PaginationResponse> {
        Log.v("vince","application pendingApplication")
        return applicationRepository.pendingApplication(take,page,applicationFilterDto)
    }


}