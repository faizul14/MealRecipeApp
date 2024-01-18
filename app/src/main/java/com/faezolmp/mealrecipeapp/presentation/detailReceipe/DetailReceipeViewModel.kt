package com.faezolmp.mealrecipeapp.presentation.detailReceipe

import androidx.lifecycle.ViewModel
import com.faezolmp.mealrecipeapp.core.domain.usecase.UseCase

class DetailReceipeViewModel(val useCase: UseCase): ViewModel() {
    val getsampleData = useCase.sampleinterface()
}