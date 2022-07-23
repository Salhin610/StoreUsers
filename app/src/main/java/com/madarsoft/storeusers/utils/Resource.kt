package com.example.rickandmorty.utils

import com.madarsoft.storeusers.data.models.UserModel

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        ValidationSucceeded,
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String): Resource<T>{
            return Resource(Status.ERROR, null, message)
        }
        fun <T> validationSucceeded(data: String): Resource<T> {
            return Resource(Status.ValidationSucceeded, null , data)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}