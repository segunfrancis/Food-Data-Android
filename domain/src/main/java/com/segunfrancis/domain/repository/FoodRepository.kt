package com.segunfrancis.domain.repository

import com.segunfrancis.domain.model.BaseResponseItemDomain
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    fun getFoodList(): Flow<List<BaseResponseItemDomain>>
}