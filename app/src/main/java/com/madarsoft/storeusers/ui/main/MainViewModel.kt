package com.madarsoft.storeusers.ui.main

import androidx.lifecycle.*
import com.example.rickandmorty.utils.Resource
import com.madarsoft.storeusers.data.models.UserModel
import com.madarsoft.storeusers.data.repositrory.UserRepository
import com.madarsoft.storeusers.utils.ValidateEnteredUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class
MainViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {


    lateinit var add: LiveData<Boolean>

    fun validateEnteredUser(userModel: UserModel): String {

        return ValidateEnteredUser(userModel)
    }


    fun addUser(userModel: UserModel) {
        add = repository.addUser(userModel)
    }


}