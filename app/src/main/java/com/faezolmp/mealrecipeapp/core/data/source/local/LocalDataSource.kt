package com.faezolmp.mealrecipeapp.core.data.source.local

import com.faezolmp.mealrecipeapp.core.data.source.local.entity.EntityMeal
import com.faezolmp.mealrecipeapp.core.data.source.local.room.DaoMeal
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val daoMeal: DaoMeal) {
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun getDataListMeal(): Flow<List<EntityMeal>> = daoMeal.getListDataMeal()

    suspend fun addDataMeal(dataMeal: EntityMeal) = daoMeal.addMeal(dataMeal)
    fun deleteDataMeal(dataMeal: EntityMeal) = executorService.execute{
        daoMeal.deleteMeal(dataMeal)
    }

}