package com.example.composableproject.data.remote

import com.example.composableproject.data.dto.ApiResponse
import com.example.composableproject.database.dao.UserTypeDao
import com.example.composableproject.database.entity.UserInfo
import com.example.composableproject.database.entity.UserType
import retrofit2.Response
import javax.inject.Inject

class UserTypeRepositoryImpl @Inject constructor (
    private val userTypeRepository : UserTypeRepository,
    private val userTypeDao: UserTypeDao
) : UserTypeRepository,UserTypeDao {


    override suspend fun fetchUserType(): Response<ApiResponse> {
        return userTypeRepository.fetchUserType()
    }

    override suspend fun getAllUserType(): List<UserType> {
        return userTypeDao.getAllUserType()
    }

    override suspend fun insertAllUserType(userTypes: List<UserType>) {
        return userTypeDao.insertAllUserType(userTypes)
    }

    override suspend fun deleteAllUserType() {
        return userTypeDao.deleteAllUserType()
    }


}