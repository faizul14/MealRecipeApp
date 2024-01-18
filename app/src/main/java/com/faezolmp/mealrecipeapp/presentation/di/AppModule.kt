package com.faezolmp.mealrecipeapp.presentation.di

import com.faezolmp.mealrecipeapp.core.domain.usecase.ImplementUseCase
import com.faezolmp.mealrecipeapp.core.domain.usecase.UseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideUseCaseForViewModelUse(useCase: ImplementUseCase): UseCase
}