package com.segunfrancis.datasource.repository

import com.segunfrancis.datasource.model.BaseResponseItemSource

interface RemoteRepository {
    suspend fun getFoodResponse(): List<BaseResponseItemSource>
}
