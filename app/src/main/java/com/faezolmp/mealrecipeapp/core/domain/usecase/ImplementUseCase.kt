package com.faezolmp.mealrecipeapp.core.domain.usecase

import com.faezolmp.mealrecipeapp.core.domain.repository.Repository

class ImplementUseCase(val repository: Repository): UseCase {
    override fun sampleinterface(): String {
        return repository.sampleinterface()
    }
}