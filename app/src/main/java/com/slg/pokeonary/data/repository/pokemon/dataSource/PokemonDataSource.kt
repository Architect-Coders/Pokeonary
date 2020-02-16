package com.slg.pokeonary.data.repository.pokemon.dataSource

import com.slg.pokeonary.data.repository.common.ServiceResultWrapper
import com.slg.pokeonary.domain.pokemon.model.Pokemon

interface PokemonDataSource {

    suspend fun getPokemonListAsync(start: Int, count: Int): ServiceResultWrapper<List<Pokemon>>
}
