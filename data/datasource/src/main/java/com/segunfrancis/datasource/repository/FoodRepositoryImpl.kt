package com.segunfrancis.datasource.repository

import com.segunfrancis.datasource.factory.DataSourceFactory
import com.segunfrancis.datasource.util.mapToDomain
import com.segunfrancis.domain.model.BaseResponseItemDomain
import com.segunfrancis.domain.repository.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(private val dataSourceFactory: DataSourceFactory) : FoodRepository {
    override suspend fun getFoodList(): List<BaseResponseItemDomain> {
        return dataSourceFactory.remote().getFoodResponse().map { baseResponseItemSource ->
            baseResponseItemSource.mapToDomain()
        }
    }
}
