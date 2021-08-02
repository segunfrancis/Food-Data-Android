package com.segunfrancis.domain.repository

import com.segunfrancis.domain.model.BaseResponseItemDomain

interface FoodRepository {
    suspend fun getFoodList(): List<BaseResponseItemDomain>
}
