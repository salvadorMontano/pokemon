package com.example.pokemon.domain

import com.example.pokemon.data.PokemonRepository
import com.example.pokemon.data.model.PokemonModel

class GetPokemonsUseCase {

    private val repository = PokemonRepository()

    suspend operator fun invoke():List<PokemonModel>? = repository.getAllPokemons()

}