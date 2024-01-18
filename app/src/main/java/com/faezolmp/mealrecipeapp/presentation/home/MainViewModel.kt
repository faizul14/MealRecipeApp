package com.faezolmp.mealrecipeapp.presentation.home

import androidx.lifecycle.ViewModel
import com.faezolmp.mealrecipeapp.core.domain.usecase.UseCase

class MainViewModel(val useCase: UseCase): ViewModel() {
    val getSampleData = useCase.sampleinterface()
}