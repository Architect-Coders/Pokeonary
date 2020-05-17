package com.slg.pokeonary.data.repository.pokemon.dataSource.remote

import com.slg.pokeonary.data.repository.common.ServiceResultWrapper
import com.slg.pokeonary.data.repository.common.safeApiCall
import com.slg.pokeonary.data.repository.pokemon.dataSource.PokemonDataSource
import com.slg.pokeonary.data.repository.pokemon.model.transformToDomain
import com.slg.pokeonary.domain.pokemon.model.Pokemon

class PokemonRemoteDataSource(private val pokemonApi: PokemonApi) : PokemonDataSource {

    override suspend fun getPokemonListAsync(start: Int, count: Int): ServiceResultWrapper<List<Pokemon>> =
        safeApiCall { pokemonApi.getPokemonListAsync(start, count) }.transformToDomain()
}
