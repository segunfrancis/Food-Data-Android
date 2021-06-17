package com.segunfrancis.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<I, O> {

    protected abstract val dispatcher: CoroutineDispatcher

    protected abstract fun buildFlowUseCase(data: I? = null): Flow<O>

    operator fun invoke(params: I? = null): Flow<O> {
        return buildFlowUseCase(params).flowOn(dispatcher)
    }
}
