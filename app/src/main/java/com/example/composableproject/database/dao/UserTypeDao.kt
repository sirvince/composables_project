package com.example.composableproject.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.composableproject.database.entity.UserInfo
import com.example.composableproject.database.entity.UserType

@Dao
interface UserTypeDao {


    @Query("SELECT * FROM usertype")
    suspend fun getAllUserType(): List<UserInfo>

    @Insert
    suspend  fun insertAllUserType(userTypes: List<UserType>)

    @Query("DELETE FROM usertype")
    suspend fun deleteAllUserType()
}