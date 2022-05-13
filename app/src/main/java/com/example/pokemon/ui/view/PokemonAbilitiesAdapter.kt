package com.example.pokemon.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.data.model.PokemonAbilitiesResponse
import com.example.pokemon.data.model.PokemonAbilityItemResponse
import com.example.pokemon.data.model.PokemonAbilityResponse
import com.example.pokemon.data.model.PokemonModel

class PokemonAbilitiesAdapter(
    private val pokemonAbilities: MutableList<PokemonAbilityResponse>,
    private val itemClickListener: OnPokemonAbilityClickListener
): RecyclerView.Adapter<PokemonAbilitiesViewHolder>() {

    interface OnPokemonAbilityClickListener{
        fun onItemClick(name: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAbilitiesViewHolder {

        var layoutInflater = LayoutInflater.from(parent.context)
        return PokemonAbilitiesViewHolder(layoutInflater.inflate(R.layout.item_pokemon_abilities, parent, false,))
    }

    override fun getItemCount(): Int = pokemonAbilities.size

    override fun onBindViewHolder(holder: PokemonAbilitiesViewHolder, position: Int) {
        val item : PokemonAbilityItemResponse =  pokemonAbilities[position].ability
        holder.bind(item.name)
        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(item.name)
        }

    }


}