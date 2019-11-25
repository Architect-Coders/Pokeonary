package com.slg.pokeonary.mobile.pokemonList.model

import com.slg.pokeonary.domain.pokemon.model.Pokemon

class PokemonViewEntity (
    val name: String?,
    val imageUrl: String?
)

private fun Pokemon.transformToUi() = PokemonViewEntity(name, imageUrl)

fun List<Pokemon>.transformToUi() = map { it.transformToUi() }