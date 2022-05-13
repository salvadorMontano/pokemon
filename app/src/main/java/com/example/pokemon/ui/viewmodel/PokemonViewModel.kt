package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.model.PokemonModel
import com.example.pokemon.data.model.PokemonProvider
import com.example.pokemon.domain.GetAllPokemonsUseCase
import com.example.pokemon.domain.GetPokemonsUseCase
import com.example.pokemon.domain.GetRandomPokemonUseCase
import kotlinx.coroutines.launch

class PokemonViewModel:ViewModel() {

    val pokemonModel = MutableLiveData<PokemonModel>()
    val isLoading = MutableLiveData<Boolean>()
    val listPokemonModel = MutableLiveData <List<PokemonModel>>()

    var getPokemonsUseCase = GetPokemonsUseCase()
    var getRandomPokemonUseCase = GetRandomPokemonUseCase()
    var getAllPokemonsUseCase = GetAllPokemonsUseCase()


    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPokemonsUseCase()
            if(!result.isNullOrEmpty()){
                listPokemonModel.postValue(result!!)
                isLoading.postValue((false))
            }
        }

    }


    /*
    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPokemonsUseCase()
            if(!result.isNullOrEmpty()){
               pokemonModel.postValue(result[0])
                isLoading.postValue((false))
            }
        }

    }

     */

    fun getAllPokemons(){
        /*
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAllPokemonsUseCase()
            if(!result.isNullOrEmpty()){
                listPokemonModel.postValue(result!!)
                isLoading.postValue((false))
            }
        }*/
        isLoading.postValue(true)
        val pokemons = getAllPokemonsUseCase()
        if(pokemons!= null){
            listPokemonModel.postValue(pokemons!!)
        }
        isLoading.postValue((false))

    }


    fun randomPokemon(){
        isLoading.postValue(true)
        val pokemon = getRandomPokemonUseCase()
        if(pokemon!= null){
            pokemonModel.postValue(pokemon!!)
        }
        isLoading.postValue((false))

    }





}