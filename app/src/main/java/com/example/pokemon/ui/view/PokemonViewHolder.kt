package com.example.pokemon.ui.view

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.ItemPokemonBinding
import com.example.pokemon.databinding.ItemPokemonBinding.*



class PokemonViewHolder(
    view: View
): RecyclerView.ViewHolder(view) {

    private val binding = bind(view)
    fun bind(name:String){
        binding.nameItem.text = name;
    }

}