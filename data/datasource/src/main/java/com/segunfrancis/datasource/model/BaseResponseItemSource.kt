package com.segunfrancis.datasource.model

data class BaseResponseItemSource(
    val description: String,
    val fdcId: Int,
    val foodNutrients: List<FoodNutrientSource>,
    val publicationDate: String
)
