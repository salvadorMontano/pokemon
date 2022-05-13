package com.example.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class PokemonEvolutionChainEvolvesToResponse(
    @SerializedName("species") var species:PokemonEvolutionChainSpecies2Response,
    @SerializedName("evolves_to") var evolves_to:List<PokemonEvolutionChainEvolves2ToResponse>,
)
