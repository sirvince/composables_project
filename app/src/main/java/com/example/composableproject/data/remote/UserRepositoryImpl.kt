package com.example.composableproject.data.remote

import com.example.composableproject.data.dto.ApiResponse
import com.example.composableproject.database.dao.UserDao
import com.example.composableproject.database.dao.UserTypeDao
import com.example.composableproject.database.entity.UserInfo
import com.example.composableproject.database.entity.UserType
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor (
    private val userRepository : UserRepository,
    private val userDao: UserDao,
//    private val userTypeDao: UserTypeDao
) : UserRepository,UserDao {


    override suspend fun fetchUserInfo(): Response<ApiResponse> {
        return userRepository.fetchUserInfo()
    }

    override suspend fun fetchUserType(): Response<ApiResponse> {
        return userRepository.fetchUserType()
    }

    override suspend fun getAll(): List<UserInfo> {
        return userDao.getAll()
    }

    override suspend fun insertAll(userInfos: List<UserInfo>) {
        return userDao.insertAll(userInfos)
    }

    override suspend fun delete() {
        return userDao.delete()
    }

//    override suspend fun getAllUserType(): List<UserInfo> {
//       return userTypeDao.getAllUserType()
//    }
//
//    override suspend fun insertAllUserType(userTypes: List<UserType>) {
//        return userTypeDao.insertAllUserType(userTypes)
//    }
//
//    override suspend fun deleteAllUserType() {
//        return userTypeDao.deleteAllUserType()
//    }

}