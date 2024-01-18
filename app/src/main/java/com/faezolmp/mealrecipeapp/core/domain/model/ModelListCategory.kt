package com.faezolmp.mealrecipeapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelListCategory(
    val strCategory: String? = null,
    val strCategoryDescription: String? = null,
    val idCategory: String? = null,
    val strCategoryThumb: String? = null
) : Parcelable
