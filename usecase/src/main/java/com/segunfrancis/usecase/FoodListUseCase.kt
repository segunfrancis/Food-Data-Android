package com.segunfrancis.usecase

import com.segunfrancis.usecase.base.FlowUseCase
import com.segunfrancis.usecase.model.BaseResponseItemUC
import com.segunfrancis.usecase.repository.FoodRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FoodListUseCase @Inject constructor(
    private val foodRepository: FoodRepository,
    override val dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, List<BaseResponseItemUC>>() {

    override fun buildFlowUseCase(data: Unit?): Flow<List<BaseResponseItemUC>> {
        return foodRepository.getFoodList()
    }
}
