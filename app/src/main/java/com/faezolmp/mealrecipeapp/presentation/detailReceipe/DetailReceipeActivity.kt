package com.faezolmp.mealrecipeapp.presentation.detailReceipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.faezolmp.mealrecipeapp.R
import com.faezolmp.mealrecipeapp.databinding.ActivityDetailReceipeBinding

class DetailReceipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailReceipeBinding
    private  val viewModel: DetailReceipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailReceipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}