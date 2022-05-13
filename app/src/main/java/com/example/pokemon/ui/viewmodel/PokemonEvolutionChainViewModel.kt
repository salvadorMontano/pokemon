package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.model.PokemonEvolutionChainResponse
import com.example.pokemon.data.model.PokemonSpecieResponse
import com.example.pokemon.domain.GetPokemonEvolutionChainUseCase
import com.example.pokemon.domain.GetPokemonSpecieUseCase
import kotlinx.coroutines.launch

class PokemonEvolutionChainViewModel : ViewModel() {

    val pokemonEvolutionChainResponse = MutableLiveData<PokemonEvolutionChainResponse>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(id:String){
        var getPokemonEvolutionChainUseCase = GetPokemonEvolutionChainUseCase(id)
        viewModelScope.launch{
            isLoading.postValue(true)
            val result = getPokemonEvolutionChainUseCase()
            if(result != null){
                pokemonEvolutionChainResponse.postValue(result!!)
                isLoading.postValue((false))
            }
        }

    }


}