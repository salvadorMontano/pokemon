package com.example.pokemon.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemon.data.model.PokemonAbilitiesResponse
import com.example.pokemon.data.model.PokemonAbilityItemResponse
import com.example.pokemon.data.model.PokemonAbilityResponse
import com.example.pokemon.data.model.PokemonModel
import com.example.pokemon.databinding.ActivityPokemonAbilitiesBinding
import com.example.pokemon.ui.viewmodel.PokemonAbilitiesViewModel

class PokemonAbilitiesActivity : AppCompatActivity(),PokemonAbilitiesAdapter.OnPokemonAbilityClickListener {

    private lateinit var binding: ActivityPokemonAbilitiesBinding
    private val pokemonAbilitiesViewModel : PokemonAbilitiesViewModel by viewModels()
    private lateinit var adapter:PokemonAbilitiesAdapter

    //private val pokemonAbilitiesInit = mutableListOf<PokemonAbilitiesResponse>()
    private val pokemonAbilitiesInit = mutableListOf<PokemonAbilityResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonAbilitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id :String = intent.getStringExtra("name").toString()
        Log.d("66669999",id)

        pokemonAbilitiesViewModel.onCreate(id)
        binding.rvAbilities.layoutManager = LinearLayoutManager(this)

        pokemonAbilitiesViewModel.pokemonAbilitiesResponse.observe(this, Observer{currentPokemonAbilities ->


            pokemonAbilitiesInit.clear()
            pokemonAbilitiesInit.addAll(currentPokemonAbilities.abilities)
            adapter = PokemonAbilitiesAdapter(pokemonAbilitiesInit,this)
            binding.rvAbilities.adapter = adapter
            adapter.notifyDataSetChanged()



        })

        pokemonAbilitiesViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

    }

    override fun onItemClick(name: String) {


    }
}