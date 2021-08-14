package com.example.sport.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sport.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_Sport)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }
}