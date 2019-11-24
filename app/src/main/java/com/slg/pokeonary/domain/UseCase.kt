package com.slg.pokeonary.domain

abstract class UseCase<in RQ, RS> {

    abstract suspend fun buildAsync(params: RQ) : RS
}