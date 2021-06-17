package com.segunfrancis.remote.mapper

import com.segunfrancis.domain.model.BaseResponseItemDomain
import com.segunfrancis.domain.model.FoodNutrientDomain
import com.segunfrancis.remote.model.BaseResponseItem
import javax.inject.Inject

class BaseResponseMapper @Inject constructor() :
    Mapper<List<BaseResponseItem>, List<BaseResponseItemDomain>> {
    override fun mapRemoteToDomain(data: List<BaseResponseItem>): List<BaseResponseItemDomain> {
        return data.map {
            BaseResponseItemDomain(
                description = it.description,
                fdcId = it.fdcId,
                publicationDate = it.publicationDate,
                foodNutrients = it.foodNutrients.map { nutrient ->
                    FoodNutrientDomain(
                        amount = nutrient.amount,
                        name = nutrient.name,
                        number = nutrient.number,
                        unitName = nutrient.unitName
                    )
                })
        }
    }
}

