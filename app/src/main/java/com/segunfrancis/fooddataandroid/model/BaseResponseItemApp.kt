package com.segunfrancis.fooddataandroid.model

data class BaseResponseItemApp(
    val description: String,
    val fdcId: Int,
    val foodNutrients: List<FoodNutrientApp>,
    val publicationDate: String
)
