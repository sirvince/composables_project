package com.example.composableproject.domain.use_case


import com.example.composableproject.data.remote.UserRepositoryImpl
import com.example.composableproject.database.entity.UserInfo
import com.example.composableproject.database.entity.UserType
import com.example.composableproject.domain.use_case.respose.AppResponse
import com.example.composableproject.util.helper.LoggerUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class FetchUserInfoUseCase @Inject constructor(
    private val userRepository: UserRepositoryImpl
) {

    suspend fun fetchUserInfo (): Any {
        return try {
            val response = userRepository.fetchUserInfo()
            if (response.isSuccessful) {
                val listType = object : TypeToken<List<UserInfo>>(){}.type
                val userInfoList: List<UserInfo> = Gson().fromJson(Gson().toJson(response.body()!!.data), listType)
                saveUserInfoToLocal(userInfoList)
                AppResponse.Success(response.body())
            } else {
                val errorBody = response.errorBody()?.string()
                if (errorBody != null) {
                    LoggerUtil().logger("FetchUserInfoUseCase","fetchUserInfo ERROR " , errorBody)
                }
                AppResponse.Error(errorBody.toString(),"Failed",)
            }
        } catch (e: Exception) {
            LoggerUtil().logger("FetchUserInfoUseCase","fetchUserInfo Exception" , e.message.toString())
            AppResponse.Error(e.message.toString(),"Exception")
        }
    }

    private suspend fun saveUserInfoToLocal (userInfoList: List<UserInfo>): Any {
        return try {
            userRepository.delete()
            userRepository.insertAll(userInfoList)
        } catch (e: Exception) {
            LoggerUtil().logger("FetchUserInfoUseCase","saveUserInfoToLocal Exception" ,  e.message.toString())
        }
    }





//    suspend fun fetchUserType (): Any {
//        return try {
//            val response = userRepository.fetchUserType()
//            if (response.isSuccessful) {
//                val listType = object : TypeToken<List<UserType>>(){}.type
//                val userTypeList: List<UserType> = Gson().fromJson(Gson().toJson(response.body()!!.data), listType)
//                saveUserTypeToLocal(userTypeList)
//                AppResponse.Success(response.body())
//            } else {
//                val errorBody = response.errorBody()?.string()
//                if (errorBody != null) {
//                    LoggerUtil().logger("FetchUserInfoUseCase","fetchUserType ERROR " , errorBody)
//                }
//                AppResponse.Error(errorBody.toString(),"Failed",)
//            }
//        } catch (e: Exception) {
//            LoggerUtil().logger("FetchUserInfoUseCase","fetchUserType Exception" , e.message.toString())
//            AppResponse.Error(e.message.toString(),"Exception")
//        }
//    }
//
//
//    private suspend fun saveUserTypeToLocal (userTypeList: List<UserType>): Any {
//        return try {
//            userRepository.deleteAllUserType()
//            userRepository.insertAllUserType(userTypeList)
//        } catch (e: Exception) {
//            LoggerUtil().logger("FetchUserInfoUseCase","saveUserTypeToLocal Exception" ,  e.message.toString())
//        }
//    }

}
