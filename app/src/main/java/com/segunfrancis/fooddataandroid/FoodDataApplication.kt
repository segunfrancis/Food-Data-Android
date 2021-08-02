package com.segunfrancis.fooddataandroid

import android.app.Application
import com.segunfrancis.fooddataandroid.di.DaggerFoodAppComponent
import com.segunfrancis.fooddataandroid.di.FoodAppComponent
import timber.log.Timber

class FoodDataApplication : Application() {

     val appComponent : FoodAppComponent by lazy {
         DaggerFoodAppComponent.factory().create()
     }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}
