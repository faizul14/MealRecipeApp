package com.faezolmp.mealrecipeapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseListByCategory(

	@field:SerializedName("meals")
	val meals: List<MealsItem>? = null
)

data class MealsItem(

	@field:SerializedName("strMealThumb")
	val strMealThumb: String? = null,

	@field:SerializedName("idMeal")
	val idMeal: String? = null,

	@field:SerializedName("strMeal")
	val strMeal: String? = null
)
