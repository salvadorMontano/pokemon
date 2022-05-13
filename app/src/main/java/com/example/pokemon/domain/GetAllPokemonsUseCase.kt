package com.example.pokemon.domain

import com.example.pokemon.data.PokemonRepository
import com.example.pokemon.data.model.PokemonModel
import com.example.pokemon.data.model.PokemonProvider

class GetAllPokemonsUseCase {

    /*
    private val repository = PokemonRepository()
    suspend operator fun invoke():List<PokemonModel>? = repository.getAllPokemons()
    */

    operator  fun invoke():List<PokemonModel>?{
        val pokemons = PokemonProvider.pokemons
        if(!pokemons.isNullOrEmpty()){
            return  pokemons
        }
        return null
    }

}