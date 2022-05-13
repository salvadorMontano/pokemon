package com.example.pokemon.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.ItemPokemonAbilitiesBinding
import com.example.pokemon.databinding.ItemPokemonAbilitiesBinding.*


class PokemonAbilitiesViewHolder(
    view: View
):RecyclerView.ViewHolder(view) {
    private val binding = bind(view)
    fun bind(name: String){
        binding.nameItem.text = name;
    }
}