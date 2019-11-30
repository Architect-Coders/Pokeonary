package com.slg.pokeonary.data.repository.pokemon.dataSource.remote

import android.content.Context
import com.slg.pokeonary.data.repository.common.WebServiceProvider
import com.slg.pokeonary.data.repository.pokemon.dataSource.PokemonDataSource
import com.slg.pokeonary.data.repository.pokemon.model.transformToDomain
import com.slg.pokeonary.domain.pokemon.model.Pokemon

class PokemonRemoteDataSource(private val context: Context) : PokemonDataSource {

    override suspend fun getPokemonListAsync(limit: Int, offset: Int): List<Pokemon> =
        WebServiceProvider(context)
            .getWebService(PokemonApi::class.java)
            .getPokemonListAsync(limit, offset)
            .transformToDomain()
}
