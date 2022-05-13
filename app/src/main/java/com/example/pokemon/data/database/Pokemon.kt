package com.example.pokemon.data.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    var id:Long=0,
    @NonNull
    var name:String
)
