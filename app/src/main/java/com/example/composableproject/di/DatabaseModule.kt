package com.example.composableproject.di

import android.content.Context
import androidx.room.Room
import com.example.composableproject.database.AppDatabase
import com.example.composableproject.database.dao.UserDao
import com.example.composableproject.database.dao.UserTypeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "asc-database"
        ).build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }


    fun provideUserTypeDao(database: AppDatabase): UserTypeDao {
        return database.userTypeDao()
    }
}