package com.faezolmp.mealrecipeapp.presentation.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealBookMark
import com.faezolmp.mealrecipeapp.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {

    private val _data = MutableLiveData<Resource<List<ModelListMealBookMark>>>()
    val data: LiveData<Resource<List<ModelListMealBookMark>>> = _data

    fun hitDb() {
        viewModelScope.launch {
            useCase.getDataMailBookmark().collect{
                _data.value = it
            }
        }
    }

//    val getListDataBookMark: LiveData<Resource<List<ModelListMealBookMark>>> = useCase.getDataMailBookmark().asLiveData()
}