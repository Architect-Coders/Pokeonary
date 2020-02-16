package com.slg.pokeonary.domain

import com.slg.pokeonary.data.repository.common.ServiceResultWrapper
import com.slg.pokeonary.domain.pokemon.model.Pokemon

abstract class UseCase<in RQ, RS> {

    abstract suspend fun buildAsync(params: RQ): ServiceResultWrapper<RS>
}
