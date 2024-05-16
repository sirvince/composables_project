package com.example.composableproject.domain.use_case


import android.util.Log
import com.example.composableproject.data.model.ApplicationFilterDto
import com.example.composableproject.data.dto.PaginationResponse
import com.example.composableproject.data.remote.ApplicationRepositoryImpl
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.google.gson.Gson
import javax.inject.Inject

class ApplicationUseCase @Inject constructor(
    private val applicationRepository: ApplicationRepositoryImpl
) {

    suspend fun application ( take: Int, page: Int,applicationFilterDto : ApplicationFilterDto): Any {
        return try {
            Log.v("vince","application")
            val response = applicationRepository.pendingApplication(take,page,applicationFilterDto)
            if (response.isSuccessful) {
                AppResponse.Success(response.body())
            } else {
                val errorBody = response.errorBody()?.string()
                val errorResponse = Gson().fromJson(errorBody, PaginationResponse::class.java)
                AppResponse.Error(errorBody.toString(),"Failed",)
            }
        } catch (e: Exception) {
            AppResponse.Error(e.message.toString(),"Exception")
        }
    }
}
