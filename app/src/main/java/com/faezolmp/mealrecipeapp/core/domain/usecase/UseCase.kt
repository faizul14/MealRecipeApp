package com.faezolmp.mealrecipeapp.core.domain.usecase

import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun sampleinterface() : String
    fun getListCategory(): Flow<Resource<List<ModelListCategory>>>
    fun getDataListBy(category: String, meal: String): Flow<Resource<List<ModelListMealByCategory>>>
}