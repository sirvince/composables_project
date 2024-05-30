package com.example.composableproject.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.composableproject.database.entity.UserInfo

@Dao
interface UserDao {
    @Query("SELECT * FROM userInfo")
    suspend fun getAll(): List<UserInfo>

    @Insert
    suspend  fun insertAll(userInfos: List<UserInfo>)

    @Query("DELETE FROM UserInfo")
    suspend fun delete()
}