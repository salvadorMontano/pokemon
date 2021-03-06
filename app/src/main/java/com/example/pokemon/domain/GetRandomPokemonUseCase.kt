package com.example.pokemon.domain

import com.example.pokemon.data.model.PokemonModel
import com.example.pokemon.data.model.PokemonProvider

class GetRandomPokemonUseCase {

    operator  fun invoke():PokemonModel?{
        val pokemons = PokemonProvider.pokemons
        if(!pokemons.isNullOrEmpty()){
           var randomNumber = (pokemons.indices).random()
            return  pokemons[randomNumber]
        }
        return null
    }

}