package com.madarsoft.storeusers.data.repositrory

import com.example.rickandmorty.utils.performGetOperation
import com.example.rickandmorty.utils.performInsertOperation
import com.madarsoft.storeusers.data.local.UserDao
import com.madarsoft.storeusers.data.models.UserModel
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val localDataSource: UserDao
) {


    fun getUsers() = performGetOperation(
        databaseQuery = { localDataSource.getAllUsers()},
    )
    fun addUser(userModel: UserModel) = performInsertOperation(
        userModel,
       insertUser =  { localDataSource.insertUser(userModel)},
    )
}