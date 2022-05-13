package com.example.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class PokemonEvolutionChainEvolves2ToResponse(
    @SerializedName("species") var species:PokemonEvolutionChainSpecies3Response,
    //@SerializedName("evolves_to") var evolves_to:List<PokemonEvolutionChainEvolves2ToResponse>,
)
