package com.madarsoft.storeusers.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: String,
    val jobTitle: String,
    val gender: String)
