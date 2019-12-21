package com.slg.pokeonary.data.repository.pokemon.dataSource.remote

import com.slg.pokeonary.data.repository.pokemon.model.PokemonRemoteEntityWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("api/v2/pokemon")
    suspend fun getPokemonListAsync(
        @Query("offset") start: Int,
        @Query("limit") count: Int
    ): PokemonRemoteEntityWrapper
}
