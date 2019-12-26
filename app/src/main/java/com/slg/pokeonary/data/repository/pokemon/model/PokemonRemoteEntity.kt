package com.slg.pokeonary.data.repository.pokemon.model

import com.slg.pokeonary.domain.pokemon.model.Pokemon

class PokemonRemoteEntity(
    val name: String?,
    val url: String?
) {
    fun isValid() = name != null
}

private fun PokemonRemoteEntity.transformToDomain() = Pokemon(name, url)

fun List<PokemonRemoteEntity>.transformToDomain() =
    filter { it.isValid() }.map { it.transformToDomain() }
