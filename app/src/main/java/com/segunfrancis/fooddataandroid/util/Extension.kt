package com.segunfrancis.fooddataandroid.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <R>MutableLiveData<R>.toLiveData(): LiveData<R> {
    return this
}
