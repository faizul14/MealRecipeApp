package com.faezolmp.mealrecipeapp.core.di

import android.content.Context
import androidx.room.Room
import com.faezolmp.mealrecipeapp.core.data.source.local.room.DaoMeal
import com.faezolmp.mealrecipeapp.core.data.source.local.room.DatabaseMeal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DatabaseMeal = Room.databaseBuilder(
        context,
        DatabaseMeal::class.java, "Meal.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideDaoMeal(database: DatabaseMeal): DaoMeal = database.daoMeal()
}