package com.example.pokemon.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.pokemon.R
import com.example.pokemon.ui.viewmodel.PokemonSpecieViewModel

class PokemonDetailActivity : AppCompatActivity() {

    private val pokemonSpecieViewModel : PokemonSpecieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        val nameItemDetail: TextView = findViewById(R.id.nameItemDetail) as TextView
        if(intent.extras != null){
            nameItemDetail.text = intent.getStringExtra("name").toString()
        }

        val baseHappinessItemDetail: TextView = findViewById(R.id.baseHappinessItemDetail) as TextView
        val captureRateItemDetail: TextView = findViewById(R.id.captureRateItemDetail) as TextView
        val colorItemDetail: TextView = findViewById(R.id.colorItemDetail) as TextView
        val eggGroupsItemDetail: TextView = findViewById(R.id.eggGroupsItemDetail) as TextView
        var concatEggGroupsItemDetail: String = ""
        var index:Int = 0
        var evolutionChainItemDetail:String = ""
        val btnEvolutionaryLineItemDetail = findViewById(R.id.evolutionaryLineItemDetail) as Button
        val btnAbilityItemDetail = findViewById(R.id.abilityItemDetail) as Button

        pokemonSpecieViewModel.onCreate(intent.getStringExtra("name").toString())
        pokemonSpecieViewModel.pokemonSpecieResponse.observe(this, Observer{ currentPokemonSpecie ->
            baseHappinessItemDetail.text = "Felicidad base : " + currentPokemonSpecie.base_happines
            captureRateItemDetail.text = "Tasa de captura : " + currentPokemonSpecie.capture_rate
            colorItemDetail.text = "Color : " + currentPokemonSpecie.color.name
            while (index < currentPokemonSpecie.egg_groups.size) {
                concatEggGroupsItemDetail += currentPokemonSpecie.egg_groups[index].name +","
                index++
            }
            eggGroupsItemDetail.text = "Grupo de huevos : " + concatEggGroupsItemDetail.substring(0, concatEggGroupsItemDetail.length-1)
            evolutionChainItemDetail = currentPokemonSpecie.evolution_chain.url

        })

        btnEvolutionaryLineItemDetail.setOnClickListener {
             if(evolutionChainItemDetail != ""){
                 val intent = Intent(this, PokemonEvolutionaryLineActivity::class.java)
                 intent.putExtra("chain",evolutionChainItemDetail)
                 startActivity(intent)
             }
        }

        btnAbilityItemDetail.setOnClickListener{
            val intent = Intent(this, PokemonAbilitiesActivity::class.java)
            intent.putExtra("name",nameItemDetail.text )
            startActivity(intent)
        }




    }
}