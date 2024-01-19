package com.faezolmp.mealrecipeapp.presentation.bookmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.faezolmp.mealrecipeapp.R
import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.helper.DataMapper
import com.faezolmp.mealrecipeapp.core.ui.ListDataByAdapter
import com.faezolmp.mealrecipeapp.databinding.ActivityBookMarkBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookMarkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookMarkBinding
    private val viewModel: BookMarkViewModel by viewModels()
    private val listBookMarkAdapter by lazy { ListDataByAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookMarkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpInit()
        observerViewModel()
    }

    private fun observerViewModel() {
        viewModel.getListDataBookMark.observe(this){dataMeal ->
            when (dataMeal) {
                is Resource.Loading -> {
//                    loading(true)
                }

                is Resource.Error -> {
                    Toast.makeText(
                        this,
                        "Error: ${dataMeal.message.toString()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is Resource.Success -> {
                    dataMeal.data?.let { listBookMarkAdapter.setData(DataMapper.mapperHelper(it)) }
                    binding.rvBokmark.adapter = listBookMarkAdapter
                    listBookMarkAdapter.notifyDataSetChanged()
//                    loading(false)
                }
            }
        }
    }

    private fun setUpInit() {
        binding.rvBokmark.apply {
            layoutManager = GridLayoutManager(
                this@BookMarkActivity,
                2
            )
            setHasFixedSize(true)
            adapter = listBookMarkAdapter
        }
    }
}