package com.example.meyman.presentation.ui.screens.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meyman.R
import com.example.meyman.presentation.ui.screens.splashScreen.SplashScreenFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}