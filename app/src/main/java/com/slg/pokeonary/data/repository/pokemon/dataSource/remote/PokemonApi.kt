package com.slg.pokeonary.data.repository.pokemon.dataSource.remote

import com.slg.pokeonary.data.repository.pokemon.model.PokemonRemoteEntity
import retrofit2.http.GET

interface PokemonApi {

    @GET
    suspend fun getPokemonListAsync(limit: Int, offset: Int): List<PokemonRemoteEntity>
}