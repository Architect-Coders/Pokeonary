package com.slg.pokeonary.mobile.pokemonList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slg.pokeonary.data.repository.common.ServiceResultWrapper
import com.slg.pokeonary.domain.pokemon.useCase.GetPokemonList
import com.slg.pokeonary.domain.pokemon.useCase.GetPokemonListParams
import com.slg.pokeonary.mobile.common.Event
import com.slg.pokeonary.mobile.pokemonList.model.PokemonViewEntity
import com.slg.pokeonary.mobile.pokemonList.model.transformToUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PokemonListViewModel(private val getPokemons: GetPokemonList) : CoroutineScope, ViewModel() {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val pokemons: List<PokemonViewEntity>) : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    private val _navigation = MutableLiveData<Event<PokemonViewEntity>>()
    val navigation: LiveData<Event<PokemonViewEntity>> = _navigation

    private fun refresh() {
        launch {
            _model.value = UiModel.Loading
            val pokemons = getPokemons.buildAsync(GetPokemonListParams(START, COUNT))
            when (pokemons) {
                is ServiceResultWrapper.Success -> {
                    _model.value = pokemons.data?.transformToUi()?.let { UiModel.Content(it) }
                }
                is ServiceResultWrapper.Error -> _model.value = UiModel.Content(listOf())
            }
        }
    }

    fun onPokemonClicked(pokemon: PokemonViewEntity) {
        _navigation.value = Event(pokemon)
    }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }

    companion object {
        const val START = 0
        const val COUNT = 20
    }
}
