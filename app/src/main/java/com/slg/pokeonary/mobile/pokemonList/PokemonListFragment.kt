package com.slg.pokeonary.mobile.pokemonList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.slg.pokeonary.R
import com.slg.pokeonary.mobile.common.inflate
import com.slg.pokeonary.mobile.pokemonList.PokemonListViewModel.UiModel.Content
import com.slg.pokeonary.mobile.pokemonList.PokemonListViewModel.UiModel.Loading
import com.slg.pokeonary.mobile.pokemonList.adapter.PokemonsAdapter
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class PokemonListFragment : Fragment() {

    private val viewModel: PokemonListViewModel by lifecycleScope.viewModel(this)
    private lateinit var navController: NavController
    private lateinit var pokemonsAdapter: PokemonsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.activity_pokemon_list, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        navController = view.findNavController()
        pokemonsAdapter = PokemonsAdapter(viewModel::onPokemonClicked)

        initializeRecyclerView()

        viewModel.model.observe(viewLifecycleOwner, Observer(::updateUi))
        viewModel.navigation.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let { pokemon ->
                val action = PokemonListFragmentDirections
                    .actionPokemonListFragmentToPokemonDetailFragment(pokemon)
                navController.navigate(action)
            }
        })
    }

    private fun initializeRecyclerView() {
        recyclerView.adapter = pokemonsAdapter
        val dividerDrawable =
            ContextCompat.getDrawable(requireContext(), R.drawable.recycler_view_divider)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            ).apply { dividerDrawable?.let { setDrawable(it) } }
        )
    }

    private fun updateUi(uiModel: PokemonListViewModel.UiModel) {
        progressBar.visibility = if (uiModel is Loading) View.VISIBLE else View.GONE
        when (uiModel) {
            is Content -> pokemonsAdapter.setItems(uiModel.pokemons)
        }
    }
}
