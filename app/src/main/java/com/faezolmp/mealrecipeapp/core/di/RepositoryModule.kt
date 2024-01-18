package com.faezolmp.mealrecipeapp.core.di

import com.faezolmp.mealrecipeapp.core.data.ImplementRepository
import com.faezolmp.mealrecipeapp.core.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(repository: ImplementRepository): Repository
}