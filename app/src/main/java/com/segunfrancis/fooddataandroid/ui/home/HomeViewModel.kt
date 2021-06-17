package com.segunfrancis.fooddataandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segunfrancis.usecase.FoodListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val useCase: FoodListUseCase): ViewModel() {

    init {
        viewModelScope.launch {
            useCase()
                .onStart {  }
                .catch {  }
                .collect {  }
        }
    }
}
