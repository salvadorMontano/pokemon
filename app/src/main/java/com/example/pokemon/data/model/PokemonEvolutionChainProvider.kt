package com.example.pokemon.data.model

class PokemonEvolutionChainProvider {

    companion object {
        var pokemonEvolutionChain: PokemonEvolutionChainResponse = PokemonEvolutionChainResponse(
            PokemonEvolutionChainChainResponse(
                PokemonEvolutionChainSpeciesResponse("",""),
                emptyList()
            )
        )
    }
}