package com.slg.pokeonary.mobile.pokemonList

import android.content.Context
import com.slg.pokeonary.data.repository.pokemon.PokemonDataRepository
import com.slg.pokeonary.data.repository.pokemon.dataSource.remote.PokemonRemoteDataSource
import com.slg.pokeonary.domain.pokemon.useCase.GetPokemonList
import com.slg.pokeonary.domain.pokemon.useCase.GetPokemonListParams
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PokemonListPresenter(private val context: Context) {

    fun onAttach() {
        val getPokemonListUseCase = GetPokemonList(PokemonDataRepository(PokemonRemoteDataSource(context)))
        GlobalScope.launch {
            val list = getPokemonListUseCase.buildAsync(GetPokemonListParams(20, 20))
            list.forEach { println(it.name) }
        }
    }

    inner class PokemonListView
}

