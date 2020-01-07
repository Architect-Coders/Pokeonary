package com.slg.pokeonary.mobile.pokemonList.model

import android.os.Parcel
import android.os.Parcelable
import com.slg.pokeonary.domain.pokemon.model.Pokemon

class PokemonViewEntity(
    val name: String?,
    val imageUrl: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonViewEntity> {
        override fun createFromParcel(parcel: Parcel): PokemonViewEntity {
            return PokemonViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<PokemonViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}

private fun Pokemon.transformToUi() = PokemonViewEntity(name, getPokemonFrontSpriteFromUrl(url))

fun List<Pokemon>.transformToUi() = map { it.transformToUi() }

private fun getPokemonFrontSpriteFromUrl(url: String?) =
    url?.run {
        val splittedUrl = split("/")
        val pokemonNumber = splittedUrl.lastOrNull { !it.isBlank() }
        pokemonNumber?.let {
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonNumber.png"
        }
    }
