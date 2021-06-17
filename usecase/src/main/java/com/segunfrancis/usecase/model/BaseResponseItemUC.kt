package com.segunfrancis.usecase.model

data class BaseResponseItemUC(
    val description: String,
    val fdcId: Int,
    val foodNutrients: List<FoodNutrientUC>,
    val publicationDate: String
)