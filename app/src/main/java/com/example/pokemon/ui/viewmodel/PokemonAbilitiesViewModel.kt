package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.model.PokemonAbilitiesResponse
import com.example.pokemon.data.model.PokemonAbilityResponse
import com.example.pokemon.domain.GetPokemonAbilitiesUseCase
import kotlinx.coroutines.launch

class PokemonAbilitiesViewModel : ViewModel() {

    val pokemonAbilitiesResponse = MutableLiveData<PokemonAbilitiesResponse>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(id:String){
        var getPokemonAbilitiesUseCase = GetPokemonAbilitiesUseCase(id)
        viewModelScope.launch {
            isLoading.postValue(true)
            var result = getPokemonAbilitiesUseCase()
            if(result != null){
                pokemonAbilitiesResponse.postValue(result!!)
                isLoading.postValue((false))
            }

        }

    }

}