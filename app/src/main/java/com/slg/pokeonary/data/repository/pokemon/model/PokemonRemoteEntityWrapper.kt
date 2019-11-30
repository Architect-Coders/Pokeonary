package com.slg.pokeonary.data.repository.pokemon.model

class PokemonRemoteEntityWrapper(val results: List<PokemonRemoteEntity>?)

fun PokemonRemoteEntityWrapper.transformToDomain() = results?.transformToDomain() ?: listOf()
