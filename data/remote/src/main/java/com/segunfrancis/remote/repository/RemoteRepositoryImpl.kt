package com.segunfrancis.remote.repository

import com.segunfrancis.datasource.model.BaseResponseItemSource
import com.segunfrancis.datasource.repository.RemoteRepository
import com.segunfrancis.remote.api.FoodApi
import com.segunfrancis.remote.util.mapToSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val api: FoodApi,
    private val dispatcher: CoroutineDispatcher
) : RemoteRepository {
    override suspend fun getFoodResponse(): List<BaseResponseItemSource> {
        return withContext(dispatcher) {
            api.getFoodList().map { baseResponseItem ->
                baseResponseItem.mapToSource()
            }
        }
    }
}
