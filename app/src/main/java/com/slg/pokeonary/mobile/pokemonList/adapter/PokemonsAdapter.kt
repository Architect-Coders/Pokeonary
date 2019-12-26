package com.slg.pokeonary.mobile.pokemonList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.slg.pokeonary.R
import com.slg.pokeonary.mobile.pokemonList.model.PokemonViewEntity
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonsAdapter : RecyclerView.Adapter<PokemonsAdapter.PokemonsViewHolder>() {

    private val items = mutableListOf<PokemonViewEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PokemonsViewHolder(parent.inflate(R.layout.item_pokemon))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PokemonsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<PokemonViewEntity>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class PokemonsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: PokemonViewEntity) = with(itemView) {
            pokemonImageView.load(item.imageUrl)
            nameTextView.text = item.name
        }
    }
}

fun ImageView.load(url: String?) = Glide.with(context).load(url).into(this)

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(
        layoutId, this,
        attachToRoot
    )
