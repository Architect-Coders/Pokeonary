package com.slg.pokeonary.domain.pokemon.useCase

import com.slg.pokeonary.domain.pokemon.PokemonRepository
import com.slg.pokeonary.domain.UseCase
import com.slg.pokeonary.domain.pokemon.model.Pokemon

class GetPokemonList(
    private val pokemonRepository: PokemonRepository
) : UseCase<GetPokemonListParams, List<Pokemon>>() {

    override suspend fun buildAsync(params: GetPokemonListParams) =
        pokemonRepository.getPokemonListAsync(params.start, params.count)
}

class GetPokemonListParams(val start: Int, val count: Int)
