package com.segunfrancis.remote.api

import com.segunfrancis.remote.BuildConfig
import com.segunfrancis.remote.model.BaseResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("v1/foods/list")
    suspend fun getFoodList(@Query("api_key") apiKey: String = BuildConfig.API_KEY): List<BaseResponseItem>
}
