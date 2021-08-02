package com.segunfrancis.remote.util

import com.segunfrancis.datasource.model.BaseResponseItemSource
import com.segunfrancis.datasource.model.FoodNutrientSource
import com.segunfrancis.remote.model.BaseResponseItem

fun BaseResponseItem.mapToSource(): BaseResponseItemSource {
    return BaseResponseItemSource(
        description = description,
        fdcId = fdcId,
        publicationDate = publicationDate,
        foodNutrients = foodNutrients.map { nutrients ->
            FoodNutrientSource(
                amount = nutrients.amount,
                name = nutrients.name,
                unitName = nutrients.unitName,
                number = nutrients.number
            )
        })
}
