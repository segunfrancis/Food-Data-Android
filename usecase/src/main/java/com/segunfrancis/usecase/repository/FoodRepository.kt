package com.segunfrancis.usecase.repository

import com.segunfrancis.usecase.model.BaseResponseItemUC
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    fun getFoodList(): Flow<List<BaseResponseItemUC>>
}