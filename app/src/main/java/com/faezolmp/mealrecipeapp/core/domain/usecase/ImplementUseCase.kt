package com.faezolmp.mealrecipeapp.core.domain.usecase

import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.data.source.local.entity.EntityMeal
import com.faezolmp.mealrecipeapp.core.domain.model.ModelDetailDataMeal
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealBookMark
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory
import com.faezolmp.mealrecipeapp.core.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ImplementUseCase @Inject constructor(
    private val repository: Repository
) : UseCase {
    override fun sampleinterface(): String {
        return repository.sampleinterface()
    }

    override fun getListCategory(): Flow<Resource<List<ModelListCategory>>> {
        return repository.getListCategory()
    }

    override fun getDataListBy(
        category: String, meal: String
    ): Flow<Resource<List<ModelListMealByCategory>>> {
        return repository.getDataListByCategoryy(category, meal)

    }

    override fun getDetailMealBy(idmeal: String): Flow<Resource<List<ModelDetailDataMeal>>> {
        return repository.getDetailMealBy(idmeal)
    }

    override fun getDataMailBookmark(): Flow<Resource<List<ModelListMealBookMark>>> {
        return repository.getDataMailBookmark()
    }

    override suspend fun addDataMealBooMark(dataBooMarkMeal: ModelListMealBookMark) {
        repository.addDataMealBooMark(dataBooMarkMeal)
    }

    override fun deleteDataMealBooMark(dataBooMarkMeal: ModelListMealBookMark) {
        repository.deleteDataMealBooMark(dataBooMarkMeal)
    }

    override fun isBookMark(idmeal: String): Flow<Boolean> = flow {
        repository.getDataMailBookmark().collect { resource ->
            when (resource) {
                is Resource.Success -> {
                    val dataList = resource.data
                    val isBookmarked = dataList?.any { it.idMeal == idmeal }
                    if (isBookmarked == true) {
                        emit(true)
                    }
                }
                else -> {
                    emit(false)
                }
            }
        }
    }
}