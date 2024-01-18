package com.faezolmp.mealrecipeapp.presentation.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.faezolmp.mealrecipeapp.R
import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.ui.ListDataByAdapter
import com.faezolmp.mealrecipeapp.databinding.ActivitySearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val viewModel: SearchViewModel by viewModels()
    private val listDataSearchAdapter by lazy { ListDataByAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpInit()
        hitView()
        observerDataViewModel()
    }

    private fun hitView() {
        binding.apply {
            search.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    lifecycleScope.launch {
                        viewModel.trackerSearch.value = p0.toString()
                    }
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })
        }
    }

    private fun setUpInit() {
        binding.rcview.apply {
            layoutManager =
                LinearLayoutManager(this@SearchActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = listDataSearchAdapter
        }
    }

    fun observerDataViewModel(){
        viewModel.querySearch.observe(this){querySearch ->
            if (!querySearch.equals("")){
                hitSearch(querySearch)
            }else{
                hitSearch(querySearch)
            }
        }
    }

    private fun loading(isLoading: Boolean){
        if (isLoading){
            binding.apply {
                rcview.visibility = View.GONE
                loadingListMeal.visibility = View.VISIBLE
            }
        }else{
            binding.apply {
                loadingListMeal.visibility = View.GONE
                rcview.visibility = View.VISIBLE
            }
        }
    }

    fun hitSearch(meal: String){
        viewModel.getListDataByMeal(meal).observe(this){dataMeal ->
            when (dataMeal) {
                is Resource.Loading -> {
                    loading(true)
                }

                is Resource.Error -> {
                    Toast.makeText(
                        this,
                        "Error: ${dataMeal.message.toString()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is Resource.Success -> {
                    dataMeal.data?.let { listDataSearchAdapter.setData(it) }
                    binding.rcview.adapter = listDataSearchAdapter
                    loading(false)
                }
            }
        }
    }
}