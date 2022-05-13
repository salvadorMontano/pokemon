package com.example.pokemon.data

import android.util.Log
import com.example.pokemon.data.model.*
import com.example.pokemon.data.network.PokemonService

class PokemonRepository {

    private val api = PokemonService()

    suspend fun getAllPokemons():List<PokemonModel>{
        val response = api.getPokemons()
        PokemonProvider.pokemons = response
        return response
    }

    suspend fun getPokemonBySpecie(specie:String):PokemonSpecieResponse{
        val response = api.getPokemonBySpecie(specie)
        PokemonSpecieProvider.pokemonSpecie = response
        return  response
    }

    suspend fun getPokemonEvolutionChain(id:String):PokemonEvolutionChainResponse{
        val response = api.getPokemonEvolutionChain(id)
        PokemonEvolutionChainProvider.pokemonEvolutionChain = response
        return response
    }

    suspend fun getPokemonAbilities(id:String): PokemonAbilitiesResponse {
        val response = api.getPokemonAbilities(id)
        PokemonAbilitiesProvider.pokemonAbilities = response
        return response
    }




}