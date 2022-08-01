package com.madarsoft.storeusers.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.madarsoft.storeusers.data.models.UserModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class UserDaoTest {


    @get:Rule
    var instantTaskExecutorRule =  InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var dao: UserDao


    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.userDao()
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insertShoppingItem() = runBlockingTest {

        val userModel = UserModel(1, "Ahmed", "30","Android Developer","Male")

        dao.insertUser(userModel)


        val allShoppingItems = dao.getAllUsers().getOrAwaitValue()

        assertThat(allShoppingItems).contains(userModel)

    }



}