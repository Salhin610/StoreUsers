package com.madarsoft.storeusers.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.rickandmorty.utils.Resource
import com.madarsoft.storeusers.data.models.UserModel
import kotlinx.coroutines.Dispatchers

fun  ValidateEnteredUser(userModel:UserModel,

): String {



        when {
            userModel.name.isEmpty() -> {
                return "Username is Empty"
            }
            userModel.age.isEmpty() -> {
                return "Age is Empty"
            }
            userModel.jobTitle.isEmpty() -> {
                return "JobTitle is Empty"
            }
            userModel.gender.isEmpty() -> {
                return "Gender is Empty"
            }
            else -> {
                return "Validation Succeeded"
            }
        }

}