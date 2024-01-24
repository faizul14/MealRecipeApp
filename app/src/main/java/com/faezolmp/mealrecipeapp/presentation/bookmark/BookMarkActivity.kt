package com.faezolmp.mealrecipeapp.presentation.bookmark

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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
        viewModel.hitDb()
        observerViewModel()
    }


    override fun onRestart() {
        super.onRestart()
        observerViewModel()
        listBookMarkAdapter.setData(null)
        viewModel.hitDb()
    }

    private fun observerViewModel() {
        viewModel.data.observe(this) { dataMeal ->
            when (dataMeal) {
                is Resource.Loading -> {
                }

                is Resource.Error -> {
                    Toast.makeText(
                        this, "Error: ${dataMeal.message.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }

                is Resource.Success -> {
                    Log.d("TRACKER", dataMeal.data.toString())
                    isLoading(dataMeal.data?.size!!)
                    dataMeal.data.let { listBookMarkAdapter.setData(DataMapper.mapperHelper(it)) }
                    binding.rvBokmark.adapter = listBookMarkAdapter
                }
            }
        }
    }

    private fun isLoading(data: Int) {
        binding.apply {
            if (data == 0) {
                rvBokmark.visibility = View.GONE
                txtNothinbook.visibility = View.VISIBLE
            } else {
                txtNothinbook.visibility = View.GONE
                rvBokmark.visibility = View.VISIBLE
            }
        }
    }

    private fun setUpInit() {
        binding.rvBokmark.apply {
            layoutManager = GridLayoutManager(
                this@BookMarkActivity, 2
            )
            setHasFixedSize(true)
            adapter = listBookMarkAdapter
        }
    }
}