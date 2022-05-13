package com.example.pokemon.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.model.PokemonSpecieResponse
import com.example.pokemon.domain.GetPokemonSpecieUseCase
import kotlinx.coroutines.launch

class PokemonSpecieViewModel: ViewModel() {

    val pokemonSpecieResponse = MutableLiveData<PokemonSpecieResponse>()
    val isLoading = MutableLiveData<Boolean>()

    //var getPokemonSpecieUseCase = GetPokemonSpecieUseCase("")

    fun onCreate(specie:String){
        var getPokemonSpecieUseCase = GetPokemonSpecieUseCase(specie)
       viewModelScope.launch{
           isLoading.postValue(true)
           val result = getPokemonSpecieUseCase()
           if(result != null){
               pokemonSpecieResponse.postValue(result!!)
               isLoading.postValue((false))
           }
       }

    }


}