package com.slg.pokeonary.data.repository.pokemon.dataSource.remote

import android.content.Context
import com.slg.pokeonary.data.repository.common.ServiceResultWrapper
import com.slg.pokeonary.data.repository.common.WebServiceProvider
import com.slg.pokeonary.data.repository.common.safeApiCall
import com.slg.pokeonary.data.repository.pokemon.dataSource.PokemonDataSource
import com.slg.pokeonary.data.repository.pokemon.model.transformToDomain
import com.slg.pokeonary.domain.pokemon.model.Pokemon

class PokemonRemoteDataSource(
    private val context: Context,
    private val pokemonApi: PokemonApi = WebServiceProvider(context).getWebService(PokemonApi::class.java)
) : PokemonDataSource {

    override suspend fun getPokemonListAsync(start: Int, count: Int): ServiceResultWrapper<List<Pokemon>> =
        safeApiCall { pokemonApi.getPokemonListAsync(start, count) }.transformToDomain()
}
