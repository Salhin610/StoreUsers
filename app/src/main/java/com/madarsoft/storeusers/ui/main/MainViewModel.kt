package com.madarsoft.storeusers.ui.main

import androidx.lifecycle.*
import com.madarsoft.storeusers.data.models.UserModel
import com.madarsoft.storeusers.data.repositrory.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class
MainViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {


    lateinit var add: LiveData<Boolean>

    fun validateEnteredUser(userModel: UserModel): String {

        return com.madarsoft.storeusers.utils.validateEnteredUser(userModel)
    }


    fun addUser(userModel: UserModel) {
        add = repository.addUser(userModel)
    }


}