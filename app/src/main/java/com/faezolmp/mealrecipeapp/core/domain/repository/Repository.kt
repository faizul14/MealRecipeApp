package com.faezolmp.mealrecipeapp.core.domain.repository

import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.data.source.local.entity.EntityMeal
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.MealsItemDetail
import com.faezolmp.mealrecipeapp.core.domain.model.ModelDetailDataMeal
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealBookMark
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun sampleinterface(): String
    fun getListCategory(): Flow<Resource<List<ModelListCategory>>>
    fun getDataListByCategoryy(category: String, meal: String): Flow<Resource<List<ModelListMealByCategory>>>
    fun getDetailMealBy(idmeal: String): Flow<Resource<List<ModelDetailDataMeal>>>

    fun getDataMailBookmark(): Flow<Resource<List<ModelListMealBookMark>>>
    suspend fun addDataMealBooMark(entityMeal: ModelListMealBookMark)
    fun deleteDataMealBooMark(dataBooMarkMeal: ModelListMealBookMark)
}