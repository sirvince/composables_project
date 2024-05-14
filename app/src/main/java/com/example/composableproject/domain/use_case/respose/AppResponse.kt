package com.example.composableproject.domain.use_case.respose

sealed class AppResponse <T>(val data : T? = null, val message : String? = null ){
    class Success<T>(data: T) : AppResponse<T>(data)
    class Error<T>(message: String, data: T? = null) : AppResponse<T>(data,message)
    class Loading<T>(data: T? = null) : AppResponse<T>(data)
}