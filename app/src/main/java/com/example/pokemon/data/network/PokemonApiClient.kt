package com.example.pokemon.data.network

import com.example.pokemon.data.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PokemonApiClient {

    /*
    @GET("pokemon")
    suspend fun getAllPokemons():Response <List<PokemonModel>>

     */
    @GET("pokemon")
    suspend fun getAllPokemons():Response <PokemonResponse>

    @GET("pokemon-species/{id}")
    suspend fun getPokemonBySpecie(@Path("id") id: String?):Response<PokemonSpecieResponse>

    @GET("evolution-chain/{id}")
    suspend fun getPokemonEvolutionChain(@Path("id") id: String?):Response<PokemonEvolutionChainResponse>

    @GET("pokemon/{id}")
    suspend fun getPokemonAbilities(@Path("id") id: String?):Response<PokemonAbilitiesResponse>


}