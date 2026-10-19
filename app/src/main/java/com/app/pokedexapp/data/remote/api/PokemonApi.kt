package com.app.pokedexapp.data.remote.api

import androidx.compose.ui.graphics.vector.Path
import androidx.contentpager.content.Query
import com.app.pokedexapp.data.remote.dto.PokemonDto
import com.app.pokedexapp.data.remote.dto.PokemonListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @retrofit2.http.Query("limit") limit: Int = 20,
        @retrofit2.http.Query("offset") offset: Int = 0,
    ): PokemonListDto

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id: String,
    ): PokemonDto
}
