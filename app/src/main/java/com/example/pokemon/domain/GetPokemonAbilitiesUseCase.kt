package com.example.pokemon.domain

import com.example.pokemon.data.PokemonRepository
import com.example.pokemon.data.model.PokemonAbilitiesResponse
import com.example.pokemon.data.model.PokemonAbilityResponse

class GetPokemonAbilitiesUseCase(val id :String) {

    private val repository = PokemonRepository()
    suspend operator fun invoke(): PokemonAbilitiesResponse? = repository.getPokemonAbilities(id)
}