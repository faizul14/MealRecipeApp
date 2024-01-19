package com.faezolmp.mealrecipeapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.faezolmp.mealrecipeapp.core.data.source.local.entity.EntityMeal

@Database(entities = [EntityMeal::class], version = 1, exportSchema = false)
abstract class DatabaseMeal: RoomDatabase() {
    abstract fun daoMeal(): DaoMeal
}