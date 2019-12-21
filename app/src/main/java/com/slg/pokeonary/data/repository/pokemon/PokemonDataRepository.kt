package com.slg.pokeonary.data.repository.pokemon

import com.slg.pokeonary.data.repository.pokemon.dataSource.remote.PokemonRemoteDataSource
import com.slg.pokeonary.domain.pokemon.PokemonRepository
import com.slg.pokeonary.domain.pokemon.model.Pokemon

class PokemonDataRepository(
    private val remoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    override suspend fun getPokemonListAsync(start: Int, count: Int): List<Pokemon> =
        remoteDataSource.getPokemonListAsync(start, count)
}
