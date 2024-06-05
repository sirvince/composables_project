package com.example.composableproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composableproject.database.dao.UserDao
import com.example.composableproject.database.dao.UserTypeDao
import com.example.composableproject.database.entity.UserInfo
import com.example.composableproject.database.entity.UserType

@Database(entities = [
    UserType::class,
    UserInfo::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun userTypeDao(): UserTypeDao
}