package com.example.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class PokemonAbilitiesResponse(
    @SerializedName("abilities") var abilities:List<PokemonAbilityResponse>
)
