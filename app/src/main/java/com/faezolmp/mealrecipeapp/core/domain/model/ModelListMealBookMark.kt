package com.faezolmp.mealrecipeapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelListMealBookMark(
    val id: Int = 0,
    val strMealThumb: String? = null,
    val idMeal: String? = null,
    val strMeal: String? = null
) : Parcelable
