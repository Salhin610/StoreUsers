package com.madarsoft.storeusers.utils


import com.madarsoft.storeusers.data.models.UserModel




/**
 * the Input is not valid if....
 * ...the  username/age/job title / gender is empty
 */

fun validateEnteredUser(
    userModel: UserModel,

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