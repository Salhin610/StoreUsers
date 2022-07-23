package com.madarsoft.storeusers.ui.showUsers

import androidx.lifecycle.ViewModel
import com.madarsoft.storeusers.data.repositrory.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class
ShowUsersViewModel  @Inject constructor(
    private val repository: UserRepository
)  : ViewModel() {

    val users = repository.getUsers()
}