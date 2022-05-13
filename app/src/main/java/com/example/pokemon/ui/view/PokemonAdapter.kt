package com.example.pokemon.ui.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.data.model.PokemonModel

class PokemonAdapter(
    private val pokemons:List<PokemonModel>,
    private val itemClickListener:OnPokemonClickListener
    ): RecyclerView.Adapter<PokemonViewHolder>() {


    interface OnPokemonClickListener{
        fun onItemClick(name: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {

        var layoutInflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(layoutInflater.inflate(R.layout.item_pokemon, parent, false,))
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item : PokemonModel =  pokemons[position]
        holder.bind(item.name)
        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(item.name)
        }

    }


}