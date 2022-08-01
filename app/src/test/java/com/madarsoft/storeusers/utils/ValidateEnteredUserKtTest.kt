package com.madarsoft.storeusers.utils

import com.google.common.truth.Truth.assertThat
import com.madarsoft.storeusers.data.models.UserModel
import org.junit.Test


class ValidateEnteredUserKtTest{



    @Test
    fun `username is empty`(){

        val result = validateEnteredUser(
            UserModel(1,"", "25","Android Developer", "Male")
        )

        assertThat(result).isEqualTo("Username is Empty")
    }
    @Test
    fun `age is empty`(){

        val result = validateEnteredUser(
            UserModel(1,"Ahmed", "","Android Developer", "Male")
        )

        assertThat(result).isEqualTo("Age is Empty")
    }
    @Test
    fun `job title is empty`(){

        val result = validateEnteredUser(
            UserModel(1,"Ahmed", "25","", "Male")
        )

        assertThat(result).isEqualTo("JobTitle is Empty")
    }
    @Test
    fun `gender is empty`(){

        val result = validateEnteredUser(
            UserModel(1,"Ahmed", "25","Android Developer", "")
        )

        assertThat(result).isEqualTo("Gender is Empty")
    }
    @Test
    fun `user is valid`(){

        val result = validateEnteredUser(
            UserModel(1,"Ahmed", "25","Android Developer", "Male")
        )

        assertThat(result).isEqualTo("Validation Succeeded")
    }



}