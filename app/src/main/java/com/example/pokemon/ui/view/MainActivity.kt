package com.example.pokemon.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Database
import androidx.room.Room
import com.example.pokemon.data.database.Pokemon
import com.example.pokemon.data.database.PokemonDb
import com.example.pokemon.data.model.PokemonModel
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.ui.viewmodel.PokemonViewModel


class MainActivity : AppCompatActivity(),PokemonAdapter.OnPokemonClickListener {



    private lateinit var binding:ActivityMainBinding
    private val pokemonViewModel : PokemonViewModel by viewModels()
    private lateinit var adapter:PokemonAdapter
    private val pokemonsInit = mutableListOf<PokemonModel>()

    private lateinit var database: PokemonDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        database = Room.databaseBuilder(
            application,PokemonDb::class.java,PokemonDb.DATABASE_NAME)
            .allowMainThreadQueries()
            .build()

        var useApi:Boolean = true
        var pokemonsLocal = database.pokemonDao.getAllPokemons()
        if(pokemonsLocal.isNotEmpty()){
           useApi = false
        }
        //Log.d("666",useApi.toString())

        binding.rvPokemons.layoutManager = LinearLayoutManager(this)

        if(useApi){
            pokemonViewModel.onCreate()
            pokemonViewModel.listPokemonModel.observe(this, Observer {currentPokemons ->
                savePokemons(currentPokemons)
                pokemonsInit.clear()
                pokemonsInit.addAll(currentPokemons as Collection<PokemonModel>)
                adapter = PokemonAdapter(pokemonsInit,this)
                binding.rvPokemons.adapter = adapter
                adapter.notifyDataSetChanged()

            })

            pokemonViewModel.isLoading.observe(this, Observer {
                binding.progress.isVisible = it
            })
        }else{

            val listPokemonModel = mutableListOf<PokemonModel>()
            pokemonsLocal.forEach{pokemonLocal ->
                val pokemonLocalTmp = PokemonModel(pokemonLocal.name,"")
                listPokemonModel.add(pokemonLocalTmp)
            }
            pokemonsInit.clear()
            pokemonsInit.addAll(listPokemonModel as Collection<PokemonModel>)
            adapter = PokemonAdapter(pokemonsInit,this)
            binding.rvPokemons.adapter = adapter
            adapter.notifyDataSetChanged()

        }




    }

    override fun onItemClick(name: String) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        intent.putExtra("name",name)
        startActivity(intent)

    }

    private fun savePokemons(currentPokemons:Collection<PokemonModel>){
        currentPokemons.forEach{
            val pokemonTmp = Pokemon(name=it.name)
            database.pokemonDao.insert(pokemonTmp)
        }
    }


}