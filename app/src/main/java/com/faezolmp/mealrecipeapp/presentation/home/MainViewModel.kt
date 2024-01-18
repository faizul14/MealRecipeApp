package com.faezolmp.mealrecipeapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.faezolmp.mealrecipeapp.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {
    val getSampleData = useCase.sampleinterface()
    val getListCategory = useCase.getListCategory().asLiveData()
    val getListDataMealByCategory = useCase.getDataListByCategoryy("test").asLiveData()
}