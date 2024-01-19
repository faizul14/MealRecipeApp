package com.faezolmp.mealrecipeapp.core.helper

import com.faezolmp.mealrecipeapp.core.data.source.local.entity.EntityMeal
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.CategoriesItem
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.MealsItem
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.MealsItemDetail
import com.faezolmp.mealrecipeapp.core.domain.model.ModelDetailDataMeal
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealBookMark
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory

object DataMapper {
    fun mapperListCategoryFromDataLayerToDomainLayer(input: List<CategoriesItem>): List<ModelListCategory> {
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

    fun mapperDataListByCategoryFromDataLayerToDomainLayer(input: List<MealsItem>): List<ModelListMealByCategory> {
        var dataResult = ArrayList<ModelListMealByCategory>()
        input.map {
            val data = ModelListMealByCategory(
                strMealThumb = it.strMealThumb,
                idMeal = it.idMeal,
                strMeal = it.strMeal,
            )
            dataResult.add(data)
        }
        return dataResult
    }


    fun mapperDataDetailFromDataLayerToDomainLayer(input: List<MealsItemDetail>): List<ModelDetailDataMeal> {
        var dataResult = ArrayList<ModelDetailDataMeal>()

        input.map {
            val data = ModelDetailDataMeal(
                strImageSource = it.strImageSource?.toString(),
                strIngredient10 = it.strIngredient10,
                strIngredient12 = it.strIngredient12,
                strIngredient11 = it.strIngredient11,
                strIngredient14 = it.strIngredient14,
                strCategory = it.strCategory,
                strIngredient13 = it.strIngredient13,
                strIngredient16 = it.strIngredient16?.toString(),
                strIngredient15 = it.strIngredient15,
                strIngredient18 = it.strIngredient18?.toString(),
                strIngredient17 = it.strIngredient17?.toString(),
                strArea = it.strArea,
                strCreativeCommonsConfirmed = it.strCreativeCommonsConfirmed?.toString(),
                strIngredient19 = it.strIngredient19?.toString(),
                strTags = it.strTags,
                idMeal = it.idMeal,
                strInstructions = it.strInstructions,
                strIngredient1 = it.strIngredient1,
                strIngredient3 = it.strIngredient3,
                strIngredient2 = it.strIngredient2,
                strIngredient20 = it.strIngredient20?.toString(),
                strIngredient5 = it.strIngredient5,
                strIngredient4 = it.strIngredient4,
                strIngredient7 = it.strIngredient7,
                strIngredient6 = it.strIngredient6,
                strIngredient9 = it.strIngredient9,
                strIngredient8 = it.strIngredient8,
                strMealThumb = it.strMealThumb,
                strMeasure20 = it.strMeasure20?.toString(),
                strYoutube = it.strYoutube,
                strMeal = it.strMeal,
                strMeasure12 = it.strMeasure12,
                strMeasure13 = it.strMeasure13,
                strMeasure10 = it.strMeasure10,
                strMeasure11 = it.strMeasure11,
                dateModified = it.dateModified?.toString(),
                strDrinkAlternate = it.strDrinkAlternate?.toString(),
                strSource = it.strSource?.toString(),
                strMeasure9 = it.strMeasure9,
                strMeasure7 = it.strMeasure7,
                strMeasure8 = it.strMeasure8,
                strMeasure5 = it.strMeasure5,
                strMeasure6 = it.strMeasure6,
                strMeasure3 = it.strMeasure3,
                strMeasure4 = it.strMeasure4,
                strMeasure1 = it.strMeasure1,
                strMeasure18 = it.strMeasure18?.toString(),
                strMeasure2 = it.strMeasure2,
                strMeasure19 = it.strMeasure19?.toString(),
                strMeasure16 = it.strMeasure16?.toString(),
                strMeasure17 = it.strMeasure17?.toString(),
                strMeasure14 = it.strMeasure14,
                strMeasure15 = it.strMeasure15
            )

            dataResult.add(data)
        }

        return dataResult
    }

    fun mapperDataListBookMarkFromDataLayerToDomainLayer(input: List<EntityMeal>): List<ModelListMealBookMark> {
        var dataResult = ArrayList<ModelListMealBookMark>()
        input.map {
            val data = ModelListMealBookMark(
                id =it.id,
                strMealThumb = it.strMealThumb,
                idMeal = it.idMeal,
                strMeal = it.strMeal,
            )
            dataResult.add(data)
        }
        return dataResult
    }

    fun mapperDataListBookMarkFromDomainLyerToDataLayer(input: ModelListMealBookMark): EntityMeal {
            val data = EntityMeal(
                id =input.id,
                strMealThumb = input.strMealThumb,
                idMeal = input.idMeal,
                strMeal = input.strMeal,
            )
        return data
    }

    fun mapperHelper(input: List<ModelListMealBookMark>): List<ModelListMealByCategory>{
        val resultData = ArrayList<ModelListMealByCategory>()
            input.map {
                val data = ModelListMealByCategory(
                    strMealThumb = it.strMealThumb,
                    idMeal = it.idMeal,
                    strMeal = it.strMeal,
                )
                resultData.add(data)
            }
        return resultData
    }
}