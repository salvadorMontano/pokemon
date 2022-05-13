package com.example.pokemon.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
abstract class PokemonDb : RoomDatabase() {

    abstract  val pokemonDao:PokemonDao
    companion object{
        const val DATABASE_NAME = "db-pokemon"
    }


}