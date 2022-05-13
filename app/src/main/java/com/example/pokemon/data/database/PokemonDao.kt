package com.example.pokemon.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PokemonDao {

    @Insert
    fun insert(pokemon:Pokemon)

    @Query("SELECT * FROM pokemons")
    fun getAllPokemons():List<Pokemon>

}