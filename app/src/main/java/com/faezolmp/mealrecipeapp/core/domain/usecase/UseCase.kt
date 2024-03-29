package com.faezolmp.mealrecipeapp.core.domain.usecase

import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.data.source.local.entity.EntityMeal
import com.faezolmp.mealrecipeapp.core.domain.model.ModelDetailDataMeal
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealBookMark
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun sampleinterface() : String
    fun getListCategory(): Flow<Resource<List<ModelListCategory>>>
    fun getDataListBy(category: String, meal: String): Flow<Resource<List<ModelListMealByCategory>>>
    fun getDetailMealBy(idmeal: String): Flow<Resource<List<ModelDetailDataMeal>>>
    fun getDataMailBookmark(): Flow<Resource<List<ModelListMealBookMark>>>

    suspend fun addDataMealBooMark(dataBooMarkMeal: ModelListMealBookMark)
    fun deleteDataMealBooMark(dataBooMarkMeal: ModelListMealBookMark)

    fun isBookMark(idmeal: String): Flow<Boolean>
}