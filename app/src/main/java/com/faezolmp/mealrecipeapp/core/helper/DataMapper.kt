package com.faezolmp.mealrecipeapp.core.helper

import com.faezolmp.mealrecipeapp.core.data.source.remote.response.CategoriesItem
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.MealsItem
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory

object DataMapper {
    fun mapperListCategoryFromDataLayerToDomainLayer(input: List<CategoriesItem>): List<ModelListCategory>{
        val dataResult = ArrayList<ModelListCategory>()
        input.map {
            val data = ModelListCategory(
                strCategory = it.strCategory,
                strCategoryDescription = it.strCategoryDescription,
                idCategory = it.idCategory,
                strCategoryThumb = it.strCategoryThumb
            )
            dataResult.add(data)
        }
        return dataResult
    }

    fun mapperDataListByCategoryFromDataLayerToDomainLayer(input: List<MealsItem>): List<ModelListMealByCategory>{
        var dataResult = ArrayList<ModelListMealByCategory>()
        input.map {
            val data = ModelListMealByCategory(
                strMealThumb = it.strMealThumb,
                idMeal = it.idMeal,
                strMeal = it.strMeal,
            )
            dataResult.add(data)
        }
        return  dataResult
    }
}