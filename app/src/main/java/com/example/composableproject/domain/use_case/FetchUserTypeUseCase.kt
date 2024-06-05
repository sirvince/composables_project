package com.example.composableproject.domain.use_case


import com.example.composableproject.data.remote.UserTypeRepositoryImpl
import com.example.composableproject.database.entity.UserType
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.example.composableproject.util.helper.LoggerUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class FetchUserTypeUseCase @Inject constructor(
    private val userTypeRepository: UserTypeRepositoryImpl
) {

    suspend fun fetchUserType(): Any {
        return try {
            val response = userTypeRepository.fetchUserType()
            if (response.isSuccessful) {
                val listType = object : TypeToken<List<UserType>>(){}.type
                val userTypeList: List<UserType> = Gson().fromJson(Gson().toJson(response.body()!!.data), listType)
                saveUserTypeToLocal(userTypeList)
                AppResponse.Success(response.body())
            } else {
                val errorBody = response.errorBody()?.string()
                if (errorBody != null) {
                    LoggerUtil().logger("FetchUserTypeUseCase","fetchUserType ERROR " , errorBody)
                }
                AppResponse.Error(errorBody.toString(),"Failed",)
            }
        } catch (e: Exception) {
            LoggerUtil().logger("FetchUserTypeUseCase","fetchUserType Exception" , e.message.toString())
            AppResponse.Error(e.message.toString(),"Exception")
        }
    }

    private suspend fun saveUserTypeToLocal (userType: List<UserType>): Any {
        return try {
            userTypeRepository.deleteAllUserType()
            userTypeRepository.insertAllUserType(userType)
        } catch (e: Exception) {
            LoggerUtil().logger("FetchUserTypeUseCase","saveUserTypeToLocal Exception" ,  e.message.toString())
        }
    }


    suspend fun fetchUserTypeFromLocal(): Any {
        return try {
            val response = userTypeRepository.getAllUserType()
            LoggerUtil().logger("FetchUserTypeUseCase","fetchUserTypeFromLocal fetchUserTypeFromLocal " , Gson().toJson(response))
            AppResponse.Success(response)
//            if (response != null) {
////                val listType = object : TypeToken<List<UserType>>(){}.type
////                val userTypeList: List<UserType> = Gson().fromJson(Gson().toJson(response), listType)
////                saveUserTypeToLocal(userTypeList)
//                AppResponse.Success(response)
//            } else {
//                val errorBody = response.errorBody()?.string()
//                if (errorBody != null) {
//                    LoggerUtil().logger("FetchUserTypeUseCase","fetchUserType ERROR " , errorBody)
//                }
//                AppResponse.Error(errorBody.toString(),"Failed",)
//            }
        } catch (e: Exception) {
            LoggerUtil().logger("FetchUserTypeUseCase","fetchUserTypeFromLocal Exception" , e.message.toString())
            AppResponse.Error(e.message.toString(),"Exception")
        }
    }

}
