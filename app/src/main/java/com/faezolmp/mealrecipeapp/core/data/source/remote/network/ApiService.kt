package com.faezolmp.mealrecipeapp.core.data.source.remote.network

import com.faezolmp.mealrecipeapp.core.data.source.remote.response.ResponseDetailMeal
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.ResponseListByCategory
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.ResponseListCategory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/json/v1/1/categories.php")
    suspend fun getListCategory(): ResponseListCategory

    @GET("api/json/v1/1/filter.php")
    suspend fun getListDataByCtegory(
        @Query("c") category: String
    ): ResponseListByCategory

    @GET("api/json/v1/1/filter.php")
    suspend fun getListDataByMeal(
        @Query("i") meal: String
    ): ResponseListByCategory

    @GET("api/json/v1/1/lookup.php")
    suspend fun getDetailMealBy(
        @Query("i") idmeal: String
    ): ResponseDetailMeal
//    api/json/v1/1/lookup.php?i=52819
}