package com.faezolmp.mealrecipeapp.presentation.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.faezolmp.mealrecipeapp.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {
    val getListDataBookMark = useCase.getDataMailBookmark().asLiveData()
}