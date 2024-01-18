package com.faezolmp.mealrecipeapp.core.data.source.remote

import android.util.Log
import com.faezolmp.mealrecipeapp.core.data.source.remote.network.ApiResponse
import com.faezolmp.mealrecipeapp.core.data.source.remote.network.ApiService
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.CategoriesItem
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.MealsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    fun getListCategory(): Flow<ApiResponse<List<CategoriesItem>>> {
        return flow {
            try {
                val response = apiService.getListCategory()
                val data = response.categories
                if (data != null && data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                    Log.d("Tracker", "Response function getListCategory $response")
                }
            } catch (e: Exception) {
                ApiResponse.Error(e.message.toString())
                Log.d(
                    "Tracker Network",
                    "Response function getListCategory Erorr ${e.message.toString()}"
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getDataListBy(category: String, meal: String): Flow<ApiResponse<List<MealsItem>>> {
        return flow<ApiResponse<List<MealsItem>>> {
            try {
                val response: Any
                if (!category.equals("")){
                    response = apiService.getListDataByCtegory(category.toString())
                }else{
                    response = apiService.getListDataByMeal(meal.toString())
                }
                val data = response.meals
                if (data != null && data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                    Log.d(
                        "Tracker",
                        "Response function getDataListByCategory $response"
                    )
                }
            } catch (e: Exception) {
                ApiResponse.Error(e.message.toString())
                Log.d(
                    "Tracker Network",
                    "Response function getDataListByCategory Erorr ${e.message.toString()}"
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}