package com.segunfrancis.datasource.util

import com.segunfrancis.datasource.model.BaseResponseItemSource
import com.segunfrancis.domain.model.BaseResponseItemDomain
import com.segunfrancis.domain.model.FoodNutrientDomain

fun BaseResponseItemSource.mapToDomain(): BaseResponseItemDomain {
    return BaseResponseItemDomain(
        description = description,
        fdcId = fdcId,
        publicationDate = publicationDate,
        foodNutrients = foodNutrients.map { nutrients ->
            FoodNutrientDomain(
                amount = nutrients.amount,
                name = nutrients.name,
                unitName = nutrients.unitName,
                number = nutrients.number
            )
        })
}
