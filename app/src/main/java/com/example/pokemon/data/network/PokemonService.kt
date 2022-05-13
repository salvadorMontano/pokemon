package com.example.pokemon.data.network

import com.example.pokemon.core.RetrofitHelper
import com.example.pokemon.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemons(): List<PokemonModel>{
        return withContext(Dispatchers.IO){
          /*
          val response = retrofit.create(PokemonApiClient::class.java).getAllPokemons()
            response.body() ?: emptyList()

           */
            val response = retrofit.create(PokemonApiClient::class.java).getAllPokemons()
            response.body()?.results ?: emptyList()

        }
    }


    suspend fun getPokemonBySpecie(specie:String): PokemonSpecieResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(PokemonApiClient::class.java).getPokemonBySpecie("$specie")
            response.body() ?: PokemonSpecieResponse("","", PokemonSpecieColorResponse("",""),
                emptyList(), PokemonSpecieEvolutionChainResponse("")
            )
        }
    }

    suspend fun getPokemonEvolutionChain(id:String):PokemonEvolutionChainResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(PokemonApiClient::class.java).getPokemonEvolutionChain("$id")
            response.body()?: PokemonEvolutionChainResponse(
                PokemonEvolutionChainChainResponse(
                    PokemonEvolutionChainSpeciesResponse("",""),
                    emptyList()
                ))
        }
    }

    suspend fun getPokemonAbilities(id:String): PokemonAbilitiesResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(PokemonApiClient::class.java).getPokemonAbilities("$id")
            response.body()?: PokemonAbilitiesResponse(
                emptyList()
            )
        }
    }



}