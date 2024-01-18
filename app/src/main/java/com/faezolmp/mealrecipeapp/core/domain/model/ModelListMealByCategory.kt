package com.faezolmp.mealrecipeapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelListMealByCategory(
    val strMealThumb: String? = null,
    val idMeal: String? = null,
    val strMeal: String? = null
) : Parcelable
