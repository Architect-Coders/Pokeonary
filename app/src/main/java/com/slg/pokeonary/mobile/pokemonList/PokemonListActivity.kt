package com.slg.pokeonary.mobile.pokemonList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.slg.pokeonary.R

class PokemonListActivity : AppCompatActivity() {

    private lateinit var viewModel: PokemonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        viewModel = ViewModelProviders.of(
            this,
            PokemonListViewModel.PokemonListViewModelFactory(this)
        )[PokemonListViewModel::class.java]

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(uiModel: PokemonListViewModel.UiModel) {
        //TODO
    }
}
