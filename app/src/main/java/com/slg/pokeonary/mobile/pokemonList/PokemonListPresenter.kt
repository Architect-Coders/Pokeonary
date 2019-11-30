package com.slg.pokeonary.mobile.pokemonList

import android.content.Context
import com.slg.pokeonary.data.repository.pokemon.PokemonDataRepository
import com.slg.pokeonary.data.repository.pokemon.dataSource.remote.PokemonRemoteDataSource
import com.slg.pokeonary.domain.pokemon.useCase.GetPokemonList
import com.slg.pokeonary.domain.pokemon.useCase.GetPokemonListParams
import com.slg.pokeonary.mobile.common.Presenter
import com.slg.pokeonary.mobile.pokemonList.model.PokemonViewEntity
import com.slg.pokeonary.mobile.pokemonList.model.transformToUi
import kotlinx.coroutines.launch

class PokemonListPresenter(private val context: Context) : Presenter<PokemonListPresenter.PokemonListView>() {

    fun onAttach() {
        val getPokemonListUseCase =
            GetPokemonList(PokemonDataRepository(PokemonRemoteDataSource(context)))
        launch {
            val pokemons = getPokemonListUseCase.buildAsync(GetPokemonListParams(START, OFFSET))
            view.showPokemonsList(pokemons.transformToUi())
        }
    }

    interface PokemonListView : View {
        fun showPokemonsList(pokemons: List<PokemonViewEntity>)
    }

    companion object {
        const val START = 0
        const val OFFSET = 20
    }
}
