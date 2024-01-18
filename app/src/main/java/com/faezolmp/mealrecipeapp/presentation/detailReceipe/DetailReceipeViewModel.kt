package com.faezolmp.mealrecipeapp.presentation.detailReceipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.faezolmp.mealrecipeapp.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailReceipeViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {
    fun getDetailDataMeal(idmeal: String) = useCase.getDetailMealBy(idmeal = idmeal).asLiveData()
}