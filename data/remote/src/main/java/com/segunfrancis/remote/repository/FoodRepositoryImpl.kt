package com.segunfrancis.remote.repository

import com.segunfrancis.domain.model.BaseResponseItemDomain
import com.segunfrancis.domain.repository.FoodRepository
import com.segunfrancis.remote.api.FoodApi
import com.segunfrancis.remote.mapper.BaseResponseMapper
import com.segunfrancis.remote.model.BaseResponseItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(private val api: FoodApi, private val mapper: BaseResponseMapper): FoodRepository {

    override fun getFoodList(): Flow<List<BaseResponseItemDomain>> {
        return flow { emit(mapper.mapRemoteToDomain(api.getFoodList())) }
    }
}
