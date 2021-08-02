package com.segunfrancis.fooddataandroid.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.segunfrancis.domain.usecase.FoodListUseCase
import com.segunfrancis.fooddataandroid.model.BaseResponseItemApp
import com.segunfrancis.fooddataandroid.util.Result
import com.segunfrancis.fooddataandroid.util.mapToApp
import com.segunfrancis.fooddataandroid.util.toLiveData
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val useCase: FoodListUseCase) : ViewModel() {

    private val _foodResponse = MutableLiveData<Result<List<BaseResponseItemApp>>>()
    val foodResponse = _foodResponse.toLiveData()

    init {
        viewModelScope.launch {
            useCase()
                .onStart {
                    Timber.d("Loading...")
                    _foodResponse.postValue(Result.Loading)
                }
                .catch {
                    Timber.e(it, "Something went wrong")
                    _foodResponse.postValue(Result.Error(it))
                }
                .collect {
                    Timber.d(it.toString())
                    _foodResponse.postValue(Result.Success(it.map { it.mapToApp() }))
                }
        }
    }
}

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory @Inject constructor(
    private val useCase: FoodListUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(useCase) as T
        } else {
            throw IllegalArgumentException("Unknown class")
        }
    }
}
