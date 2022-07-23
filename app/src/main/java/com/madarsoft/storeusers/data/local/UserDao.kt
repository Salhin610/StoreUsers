package com.madarsoft.storeusers.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.madarsoft.storeusers.data.models.UserModel
import java.util.concurrent.CompletableFuture

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAllUsers() : LiveData<List<UserModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertUser(userModel: UserModel)

}