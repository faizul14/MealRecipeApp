package com.faezolmp.mealrecipeapp.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class EntityMeal(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "strMealThumb")
    val strMealThumb: String? = null,
    @ColumnInfo(name = "idMeal")
    val idMeal: String? = null,
    @ColumnInfo(name = "strMeal")
    val strMeal: String? = null
): Parcelable
