package com.segunfrancis.domain.usecase

import com.segunfrancis.domain.repository.FoodRepository
import com.segunfrancis.domain.base.FlowUseCase
import com.segunfrancis.domain.model.BaseResponseItemDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FoodListUseCase @Inject constructor(
    private val foodRepository: FoodRepository,
    override val dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, List<BaseResponseItemDomain>>() {

    override fun buildFlowUseCase(data: Unit?): Flow<List<BaseResponseItemDomain>> {
        return flow { emit(foodRepository.getFoodList()) }
    }
}
