package com.faezolmp.mealrecipeapp.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.faezolmp.mealrecipeapp.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {
    val trackerSearch = MutableStateFlow("")

    val querySearch = trackerSearch
        .debounce(100)
        .distinctUntilChanged()
//        .filter {
//            it.trim().isNotEmpty()
//        }
        .mapLatest {
            it
        }.asLiveData()

    fun getListDataByMeal(meal: String) = useCase.getDataListBy(category = "", meal).asLiveData()
}