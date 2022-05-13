package com.example.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class PokemonAbilityResponse(
    @SerializedName("ability") var ability:PokemonAbilityItemResponse
)
