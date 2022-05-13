package com.example.pokemon.domain

import com.example.pokemon.data.PokemonRepository
import com.example.pokemon.data.model.PokemonSpecieResponse

class GetPokemonSpecieUseCase(val specie: String) {

    private val repository = PokemonRepository()
    suspend operator fun invoke():PokemonSpecieResponse? = repository.getPokemonBySpecie(specie)


}