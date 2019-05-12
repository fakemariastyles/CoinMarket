package com.mmb.coinmarket.domain.executor

import io.reactivex.Scheduler

interface UseCaseExecutorThread{
    val scheduler : Scheduler
}