package com.segunfrancis.domain.model

data class BaseResponseItemDomain(
    val description: String,
    val fdcId: Int,
    val foodNutrients: List<FoodNutrientDomain>,
    val publicationDate: String
)