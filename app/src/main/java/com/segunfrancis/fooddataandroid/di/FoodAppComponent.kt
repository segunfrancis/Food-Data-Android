package com.segunfrancis.fooddataandroid.di

import com.segunfrancis.fooddataandroid.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [FoodRepoModule::class, DispatcherModule::class, NetworkModule::class])
interface FoodAppComponent {

    @Component.Factory
    interface Factory {
        fun create(): FoodAppComponent
    }

    fun inject(fragment: HomeFragment)
}
