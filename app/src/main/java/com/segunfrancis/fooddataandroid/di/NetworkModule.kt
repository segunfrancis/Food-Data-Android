package com.segunfrancis.fooddataandroid.di

import com.google.gson.Gson
import com.segunfrancis.remote.BuildConfig
import com.segunfrancis.remote.api.FoodApi
import com.segunfrancis.remote.util.RemoteConstants.BASE_URL
import com.segunfrancis.remote.util.RemoteConstants.TIMEOUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    fun provideApi(): FoodApi {
        return retrofit().create(FoodApi::class.java)
    }

    private fun retrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson()))
            .build()
    }

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(httpLoggingInterceptor())
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .callTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }

    private fun gson(): Gson {
        return Gson().newBuilder().setLenient().create()
    }
}
