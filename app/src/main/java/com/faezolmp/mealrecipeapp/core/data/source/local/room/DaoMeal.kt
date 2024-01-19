package com.faezolmp.mealrecipeapp.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.faezolmp.mealrecipeapp.core.data.source.local.entity.EntityMeal
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoMeal {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMeal(entityMeal: EntityMeal)

    @Delete
    fun deleteMeal(entityMeal: EntityMeal)

    @Query("SELECT * FROM EntityMeal")
    fun getListDataMeal(): Flow<List<EntityMeal>>
}