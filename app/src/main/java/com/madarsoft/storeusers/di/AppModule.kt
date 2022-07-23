package com.madarsoft.storeusers.di

import android.content.Context
import com.madarsoft.storeusers.data.local.AppDatabase
import com.madarsoft.storeusers.data.local.UserDao
import com.madarsoft.storeusers.data.repositrory.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase) = db.userDao()

    @Singleton
    @Provides
    fun provideRepository(localDataSource: UserDao) =

        UserRepository(localDataSource)
}