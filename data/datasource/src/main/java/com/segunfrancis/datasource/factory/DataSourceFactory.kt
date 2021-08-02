package com.segunfrancis.datasource.factory

import com.segunfrancis.datasource.repository.RemoteRepository
import javax.inject.Inject

class DataSourceFactory @Inject constructor(private val remoteRepository: RemoteRepository) {

    fun remote(): RemoteRepository = remoteRepository
}
