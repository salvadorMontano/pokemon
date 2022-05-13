package com.example.pokemon.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.pokemon.R
import com.example.pokemon.ui.viewmodel.PokemonEvolutionChainViewModel
import com.example.pokemon.ui.viewmodel.PokemonSpecieViewModel

class PokemonEvolutionaryLineActivity : AppCompatActivity() {

    private val pokemonEvolutionChainViewModel : PokemonEvolutionChainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_evolutionary_line)

        var id :String = ""
        if(intent.extras != null){
            id = intent.getStringExtra("chain").toString()
        }
        id = id.substring(0, id.length-1)

        val list = id.split("/")
        var finalId = list[list.size-1].toString()


        val btnEvolution1 = findViewById(R.id.evolution1) as Button
        val btnEvolution2 = findViewById(R.id.evolution2) as Button
        val btnEvolution3 = findViewById(R.id.evolution3) as Button

        pokemonEvolutionChainViewModel.onCreate(finalId)
        pokemonEvolutionChainViewModel.pokemonEvolutionChainResponse.observe(this, Observer{ currentPokemonEvolutionChain ->

            var contentPlain : String = currentPokemonEvolutionChain.chain.species.name
            var contentPlain2 : String = currentPokemonEvolutionChain.chain.evolves_to[0].species.name
            var contentPlain3 : String = currentPokemonEvolutionChain.chain.evolves_to[0].evolves_to[0].species.name

            btnEvolution1.text = contentPlain
            if(contentPlain != ""){
                btnEvolution1.isVisible = true
            }
            btnEvolution2.text = contentPlain2
            if(contentPlain2 != ""){
                btnEvolution2.isVisible = true
            }
            btnEvolution3.text = contentPlain3
            if(contentPlain3 != ""){
                btnEvolution3.isVisible = true
            }

        })




    }
}