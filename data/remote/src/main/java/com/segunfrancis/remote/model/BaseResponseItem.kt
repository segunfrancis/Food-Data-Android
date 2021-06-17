package com.segunfrancis.remote.model

data class BaseResponseItem(
    val description: String,
    val fdcId: Int,
    val foodNutrients: List<FoodNutrient>,
    val publicationDate: String
)