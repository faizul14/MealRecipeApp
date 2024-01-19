package com.faezolmp.mealrecipeapp.presentation.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.faezolmp.mealrecipeapp.R
import com.faezolmp.mealrecipeapp.presentation.home.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        lifecycleScope.launch {
            delay(3000)
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            this@SplashScreenActivity.finish()
        }
    }
}