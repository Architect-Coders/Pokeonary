package com.slg.pokeonary.domain.pokemon

import com.slg.pokeonary.domain.pokemon.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemonListAsync(limit: Int, offset: Int): List<Pokemon>
}