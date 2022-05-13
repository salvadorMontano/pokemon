package com.example.pokemon.domain

import com.example.pokemon.data.PokemonRepository
import com.example.pokemon.data.model.PokemonEvolutionChainResponse

class GetPokemonEvolutionChainUseCase(val id: String) {

    private val repository = PokemonRepository()
    suspend operator fun invoke():PokemonEvolutionChainResponse ?= repository.getPokemonEvolutionChain(id)
}