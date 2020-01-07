package com.slg.pokeonary.mobile.pokemonDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.slg.pokeonary.R
import com.slg.pokeonary.mobile.common.inflate
import com.slg.pokeonary.mobile.common.load
import kotlinx.android.synthetic.main.fragment_pokemon_detail.*

class PokemonDetailFragment : Fragment() {

    private val args: PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.fragment_pokemon_detail)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemonImageView.load(args.pokemon.imageUrl)
        pokemonName.text = args.pokemon.name
    }
}
