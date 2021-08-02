package com.segunfrancis.fooddataandroid.util

import com.segunfrancis.domain.model.BaseResponseItemDomain
import com.segunfrancis.fooddataandroid.model.BaseResponseItemApp
import com.segunfrancis.fooddataandroid.model.FoodNutrientApp

fun BaseResponseItemDomain.mapToApp(): BaseResponseItemApp {
    return BaseResponseItemApp(
        description = description,
        fdcId = fdcId,
        publicationDate = publicationDate,
        foodNutrients = foodNutrients.map { nutrients ->
            FoodNutrientApp(
                amount = nutrients.amount,
                name = nutrients.name,
                unitName = nutrients.unitName,
                number = nutrients.number
            )
        })
}
