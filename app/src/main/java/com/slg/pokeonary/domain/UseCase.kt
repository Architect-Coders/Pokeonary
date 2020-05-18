package com.slg.pokeonary.domain

import com.slg.pokeonary.data.repository.common.ServiceResultWrapper

interface UseCase<in RQ, RS> {

    suspend fun buildAsync(params: RQ): ServiceResultWrapper<RS>
}
