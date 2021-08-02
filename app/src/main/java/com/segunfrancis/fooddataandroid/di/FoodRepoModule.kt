package com.segunfrancis.fooddataandroid.di

import com.segunfrancis.datasource.repository.FoodRepositoryImpl
import com.segunfrancis.datasource.repository.RemoteRepository
import com.segunfrancis.domain.repository.FoodRepository
import com.segunfrancis.remote.repository.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface FoodRepoModule {

    @Binds
    fun bindFoodRepository(foodRepositoryImpl: FoodRepositoryImpl): FoodRepository

    @Binds
    fun bindRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl): RemoteRepository

}
