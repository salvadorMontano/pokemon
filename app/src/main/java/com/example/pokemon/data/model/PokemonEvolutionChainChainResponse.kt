package com.example.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class PokemonEvolutionChainChainResponse(
    @SerializedName("species") var species:PokemonEvolutionChainSpeciesResponse,
    @SerializedName("evolves_to") var evolves_to:List<PokemonEvolutionChainEvolvesToResponse>,

)
