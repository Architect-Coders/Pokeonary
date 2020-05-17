package com.slg.pokeonary.data.repository.pokemon

import com.slg.pokeonary.data.repository.common.ServiceResultWrapper
import com.slg.pokeonary.data.repository.pokemon.dataSource.PokemonDataSource
import com.slg.pokeonary.domain.pokemon.PokemonRepository
import com.slg.pokeonary.domain.pokemon.model.Pokemon

class PokemonDataRepository(private val dataSource: PokemonDataSource) : PokemonRepository {

    override suspend fun getPokemonListAsync(start: Int, count: Int): ServiceResultWrapper<List<Pokemon>> =
        dataSource.getPokemonListAsync(start, count)
}
