package com.app.pokedexapp.domain.repository

import com.app.pokedexapp.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemonList(): List<Pokemon>

    suspend fun getPokemonById(id: String): Pokemon
}

/*class FakePokemonRepository : PokemonRepository {
    override suspend fun getPokemonList() = fakePokemonList

    override suspend fun getPokemonById(id) = fakePokemon
}*/
