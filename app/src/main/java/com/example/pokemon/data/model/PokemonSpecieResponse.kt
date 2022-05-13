package com.example.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class PokemonSpecieResponse(

    @SerializedName("base_happiness") var base_happines:String,
    @SerializedName("capture_rate") var capture_rate:String,
    @SerializedName("color") var color:PokemonSpecieColorResponse,
    @SerializedName("egg_groups") var egg_groups:List<PokemonSpecieEggGroupsResponse>,
    @SerializedName("evolution_chain") var evolution_chain:PokemonSpecieEvolutionChainResponse,
)
