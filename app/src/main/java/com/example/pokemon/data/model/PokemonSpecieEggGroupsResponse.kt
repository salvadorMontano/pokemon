package com.example.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class PokemonSpecieEggGroupsResponse(
    @SerializedName("name") var name:String,
    @SerializedName("url") var url:String,
)
