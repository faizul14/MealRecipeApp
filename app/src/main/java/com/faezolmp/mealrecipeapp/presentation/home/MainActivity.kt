package com.faezolmp.mealrecipeapp.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.ui.ListCategoryAdapter
import com.faezolmp.mealrecipeapp.core.ui.ListDataByAdapter
import com.faezolmp.mealrecipeapp.databinding.ActivityMainBinding
import com.faezolmp.mealrecipeapp.presentation.bookmark.BookMarkActivity
import com.faezolmp.mealrecipeapp.presentation.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ListCategoryAdapter.CallBackInterface {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val listCategoryAdapter by lazy { ListCategoryAdapter(this@MainActivity) }
    private val listDataMealByCategoryAdapter by lazy { ListDataByAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpInit()
        hitView()
        viewModelObserver()
    }

    private fun hitView() {
        binding.apply {
            editText.setOnClickListener {
                val move = Intent(this@MainActivity, SearchActivity::class.java)
                startActivity(move)
            }
            imageViewGotobookmark.setOnClickListener {
                val move = Intent(this@MainActivity, BookMarkActivity::class.java)
                startActivity(move)
            }
        }
    }

    private fun setUpInit() {
        binding.rvCg.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = listCategoryAdapter
        }

        binding.rvListMeal.apply {
            layoutManager = GridLayoutManager(
                this@MainActivity,
                2
            )
            setHasFixedSize(true)
            adapter = listDataMealByCategoryAdapter
        }
    }

    private fun viewModelObserver() {
        viewModel.getListCategory.observe(this) { dataListCategory ->
            when (dataListCategory) {
                is Resource.Loading -> {
                    Toast.makeText(this, "Loading .. .", Toast.LENGTH_SHORT).show()
                }

                is Resource.Error -> {
                    Toast.makeText(
                        this,
                        "Error: ${dataListCategory.message.toString()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is Resource.Success -> {
                    dataListCategory.data?.let { listCategoryAdapter.setData(it) }
                    binding.rvCg.adapter = listCategoryAdapter
                }
            }
        }

        viewModel.categoryValue.observe(this){dataCategory ->
            visibleLoading()
            if (!dataCategory.equals("")){
                observerListDataByCategory(dataCategory)
            }
        }
    }

    fun observerListDataByCategory(category: String){
        viewModel.getListDataMealByCategory(category).observe(this){dataMeal ->
            when (dataMeal) {
                is Resource.Loading -> {
                    Toast.makeText(this, "Loading .. .", Toast.LENGTH_SHORT).show()
                }

                is Resource.Error -> {
                    Toast.makeText(
                        this,
                        "Error: ${dataMeal.message.toString()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is Resource.Success -> {
                    dataMeal.data?.let { listDataMealByCategoryAdapter.setData(it) }
                    binding.rvListMeal.adapter = listDataMealByCategoryAdapter
                }
            }
        }
    }

    private fun visibleLoading(){
        binding.apply {
            loadingListMeal.visibility = View.GONE
            rvListMeal.visibility = View.VISIBLE
        }
    }
    override fun passingDataFromAdapterToActivity(category: String) {
        binding.apply {
            rvListMeal.visibility = View.GONE
            loadingListMeal.visibility = View.VISIBLE
        }
//        Toast.makeText(this@MainActivity, category, Toast.LENGTH_SHORT).show()
        try {
            lifecycleScope.launch {
                viewModel.categoryClick.value = category
            }
        }catch (e: Exception){
            Log.d("Tracker MainActivity", e.message.toString())
        }
    }

}