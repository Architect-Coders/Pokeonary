package com.slg.pokeonary.mobile.pokemonList

import android.app.Activity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.slg.pokeonary.R
import com.slg.pokeonary.mobile.pokemonList.model.PokemonViewEntity
import kotlinx.android.synthetic.main.activity_pokemon_list.*

class PokemonListActivity: Activity(), PokemonListPresenter.PokemonListView {

    private val presenter by lazy { PokemonListPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        presenter.attachView(this)
        presenter.onAttach()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun showPokemonsList(pokemons: List<PokemonViewEntity>) {
        // TODO
    }
}
