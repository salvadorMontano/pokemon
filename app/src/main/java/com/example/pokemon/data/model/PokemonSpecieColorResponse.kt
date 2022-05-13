package com.example.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class PokemonSpecieColorResponse(
    @SerializedName("name") var name:String,
    @SerializedName("url") var url:String
)