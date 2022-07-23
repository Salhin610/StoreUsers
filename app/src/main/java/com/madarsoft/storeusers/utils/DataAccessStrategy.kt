package com.example.rickandmorty.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.rickandmorty.utils.Resource.Status.*
import com.madarsoft.storeusers.data.models.UserModel
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.Continuation
import kotlin.coroutines.startCoroutine

/*
* Get All users From Local DB
* */
fun <T> performGetOperation(databaseQuery: () -> LiveData<T>
): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val source = databaseQuery.invoke().map { Resource.success(it) }
        emitSource(source)
    }



/*
* Insert user to Local DB
* */
fun  performInsertOperation(
    userModel: UserModel,
    insertUser : suspend (UserModel) -> Unit
) :LiveData<Boolean>  =  liveData(Dispatchers.IO) {

    insertUser(userModel)
    emit(true)
}

