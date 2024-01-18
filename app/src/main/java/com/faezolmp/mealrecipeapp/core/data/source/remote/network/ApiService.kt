package com.faezolmp.mealrecipeapp.core.data.source.remote.network

import com.faezolmp.mealrecipeapp.core.data.source.remote.response.CategoriesItem
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.MealsItem
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.ResponseListByCategory
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.ResponseListCategory
import retrofit2.http.GET

interface ApiService {
    @GET("api/json/v1/1/categories.php")
    suspend fun getListCategory() : ResponseListCategory

    @GET("api/json/v1/1/filter.php?c=Seafood")
    suspend fun getListDataByCtegory() : ResponseListByCategory
}