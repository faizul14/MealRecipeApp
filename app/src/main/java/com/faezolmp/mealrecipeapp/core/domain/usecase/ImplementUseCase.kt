package com.faezolmp.mealrecipeapp.core.domain.usecase

import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
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

    override fun getDataListByCategoryy(
        category: String
    ): Flow<Resource<List<ModelListMealByCategory>>> = repository.getDataListByCategoryy(category)
}