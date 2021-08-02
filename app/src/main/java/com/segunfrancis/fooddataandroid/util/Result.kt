package com.segunfrancis.fooddataandroid.util

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    class Error(val error: Throwable) : Result<Nothing>()
    object Loading : Result<Nothing>()
}
