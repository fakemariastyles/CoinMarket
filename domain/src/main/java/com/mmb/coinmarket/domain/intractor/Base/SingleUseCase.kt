package com.mmb.coinmarket.domain.intractor.Base

import com.mmb.coinmarket.domain.executor.UseCaseExecutorObserveThread
import com.mmb.coinmarket.domain.executor.UseCaseExecutorThread
import io.reactivex.Single

abstract class SingleUseCase<in Params, Result>(
    private val thread: UseCaseExecutorThread,
    private val observeThread: UseCaseExecutorObserveThread
) : UseCase() {
    abstract fun buildSingle(params: Params): Single<Result>
    fun execute(params: Params, success: (Result) -> Unit, failure: (Throwable) -> Unit) {
        buildSingle(params)
            .observeOn(observeThread.scheduler)
            .subscribeOn(thread.scheduler)
            .subscribe({success(it)}, {failure(it)})
            .also {
                add(it)
            }
    }
}