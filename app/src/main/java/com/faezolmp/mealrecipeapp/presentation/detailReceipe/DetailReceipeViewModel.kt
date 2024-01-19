package com.faezolmp.mealrecipeapp.presentation.detailReceipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealBookMark
import com.faezolmp.mealrecipeapp.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailReceipeViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {
    fun getDetailDataMeal(idmeal: String) = useCase.getDetailMealBy(idmeal = idmeal).asLiveData()
    fun addDataBookMarkMeal(dataBokmarkMeal: ModelListMealBookMark) = viewModelScope.launch {
        useCase.addDataMealBooMark(dataBokmarkMeal)
    }

    fun deleteDataBookMark(dataBokmarkMeal: ModelListMealBookMark){
        useCase.deleteDataMealBooMark(dataBokmarkMeal)
    }

    fun isBookMark(idmeal: String) = useCase.isBookMark(idmeal).asLiveData()
}