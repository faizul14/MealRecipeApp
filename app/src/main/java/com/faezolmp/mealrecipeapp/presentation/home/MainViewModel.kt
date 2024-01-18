package com.faezolmp.mealrecipeapp.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.faezolmp.mealrecipeapp.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {

    val categoryClick = MutableStateFlow("")

    val categoryValue = categoryClick
        .debounce(300)
        .distinctUntilChanged()
        .filter {
            it.trim().isNotEmpty()
        }
        .mapLatest {
            it
        }.asLiveData()

    val getSampleData = useCase.sampleinterface()
    val getListCategory = useCase.getListCategory().asLiveData()
    fun getListDataMealByCategory(category: String) = useCase.getDataListByCategoryy(category).asLiveData()
}