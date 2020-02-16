package com.slg.pokeonary.data.repository.pokemon.model

import com.slg.pokeonary.data.repository.common.ServiceResultWrapper
import com.slg.pokeonary.domain.pokemon.model.Pokemon

class PokemonRemoteEntityWrapper(val results: List<PokemonRemoteEntity>?)

fun ServiceResultWrapper<PokemonRemoteEntityWrapper>.transformToDomain() : ServiceResultWrapper<List<Pokemon>> = when(this) {
    is ServiceResultWrapper.Success -> ServiceResultWrapper.Success(data?.results?.transformToDomain() ?: listOf())
    is ServiceResultWrapper.Error -> ServiceResultWrapper.Error(exception)
}

