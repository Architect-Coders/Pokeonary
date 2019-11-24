package com.slg.pokeonary.data.repository.pokemon.dataSource

import com.slg.pokeonary.domain.pokemon.model.Pokemon

interface PokemonDataSource {

    suspend fun getPokemonListAsync(limit: Int, offset: Int): List<Pokemon>
}