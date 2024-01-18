package com.faezolmp.mealrecipeapp.core.domain.repository

import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun sampleinterface(): String
    fun getListCategory(): Flow<Resource<List<ModelListCategory>>>
    fun getDataListByCategoryy(category: String, meal: String): Flow<Resource<List<ModelListMealByCategory>>>
}