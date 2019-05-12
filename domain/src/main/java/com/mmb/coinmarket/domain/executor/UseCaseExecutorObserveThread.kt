package com.mmb.coinmarket.domain.executor

import io.reactivex.Scheduler

interface UseCaseExecutorObserveThread{
    val scheduler : Scheduler
}