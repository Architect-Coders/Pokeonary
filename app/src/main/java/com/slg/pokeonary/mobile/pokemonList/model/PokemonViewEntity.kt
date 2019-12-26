package com.slg.pokeonary.mobile.pokemonList.model

import com.slg.pokeonary.domain.pokemon.model.Pokemon

class PokemonViewEntity(
    val name: String?,
    val imageUrl: String?
)

private fun Pokemon.transformToUi() = PokemonViewEntity(name, getPokemonFrontSpriteFromUrl(url))

fun List<Pokemon>.transformToUi() = map { it.transformToUi() }

private fun getPokemonFrontSpriteFromUrl(url: String?) =
    url?.run {
        val splittedUrl = split("/")
        val pokemonNumber = splittedUrl.lastOrNull { !it.isBlank() }
        pokemonNumber?.let {
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonNumber.png"
        }
    }
