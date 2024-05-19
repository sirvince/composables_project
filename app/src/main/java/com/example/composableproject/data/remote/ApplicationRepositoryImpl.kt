package com.example.composableproject.data.remote

import android.util.Log
import com.example.composableproject.data.model.ApplicationFilterDto
import com.example.composableproject.data.dto.PaginationResponse
import com.example.composableproject.data.model.DataObject
import retrofit2.Response
import javax.inject.Inject

class ApplicationRepositoryImpl @Inject constructor( private val applicationRepository: ApplicationRepository) : ApplicationRepository {


    override suspend fun pendingApplication(
        take: Int,
        page: Int,
        search: String
    ): Response<PaginationResponse> {
        Log.v("vince","application pendingApplication")
        return applicationRepository.pendingApplication(take,page,search)
    }

    override suspend fun fetchApplication(applicationId: Int): Response<DataObject> {
        return applicationRepository.fetchApplication(applicationId)
    }


}