package com.slg.pokeonary.domain.pokemon

import com.slg.pokeonary.domain.pokemon.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemonListAsync(start: Int, count: Int): List<Pokemon>
}
