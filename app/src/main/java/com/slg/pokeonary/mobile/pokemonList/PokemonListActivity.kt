package com.slg.pokeonary.mobile.pokemonList

import android.app.Activity
import android.os.Bundle
import com.slg.pokeonary.R

class PokemonListActivity: Activity() {

    val presenter = PokemonListPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        presenter.onAttach()
    }
}