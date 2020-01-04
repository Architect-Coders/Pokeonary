package com.slg.pokeonary.mobile.pokemonList

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.slg.pokeonary.R
import com.slg.pokeonary.mobile.pokemonList.PokemonListViewModel.UiModel.Content
import com.slg.pokeonary.mobile.pokemonList.PokemonListViewModel.UiModel.Loading
import com.slg.pokeonary.mobile.pokemonList.adapter.PokemonsAdapter
import kotlinx.android.synthetic.main.activity_pokemon_list.*

class PokemonListActivity : AppCompatActivity() {

    private lateinit var viewModel: PokemonListViewModel
    private lateinit var pokemonsAdapter: PokemonsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        viewModel = ViewModelProviders.of(
            this,
            PokemonListViewModel.PokemonListViewModelFactory(application)
        )[PokemonListViewModel::class.java]

        pokemonsAdapter = PokemonsAdapter()
        initializeRecyclerView()

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun initializeRecyclerView() {
        recyclerView.adapter = pokemonsAdapter
        val dividerDrawable = ContextCompat.getDrawable(this, R.drawable.recycler_view_divider)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
            .apply { dividerDrawable?.let { setDrawable(it) } })
    }

    private fun updateUi(uiModel: PokemonListViewModel.UiModel) {
        progressBar.visibility = if (uiModel is Loading) View.VISIBLE else View.GONE
        when (uiModel) {
            is Content -> pokemonsAdapter.setItems(uiModel.pokemons)
        }
    }
}
