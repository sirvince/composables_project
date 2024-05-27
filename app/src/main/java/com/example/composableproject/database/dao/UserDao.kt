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

    @Query("SELECT * FROM userInfo WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserInfo>

    @Query("SELECT * FROM userInfo WHERE fname LIKE :first AND " +
           "lname LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): UserInfo

    @Insert
    suspend  fun insertAll(vararg userInfos: UserInfo)

    @Delete
    fun delete(userInfo: UserInfo)
}