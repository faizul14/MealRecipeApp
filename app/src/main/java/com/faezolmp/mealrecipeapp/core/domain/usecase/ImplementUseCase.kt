package com.faezolmp.mealrecipeapp.core.domain.usecase

import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.data.source.local.entity.EntityMeal
import com.faezolmp.mealrecipeapp.core.domain.model.ModelDetailDataMeal
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealBookMark
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory
import com.faezolmp.mealrecipeapp.core.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
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
}