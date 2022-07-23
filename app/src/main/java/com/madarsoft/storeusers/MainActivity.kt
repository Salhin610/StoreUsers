package com.madarsoft.storeusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madarsoft.storeusers.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}