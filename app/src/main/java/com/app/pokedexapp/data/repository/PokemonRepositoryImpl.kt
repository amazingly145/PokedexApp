package com.app.pokedexapp.data.repository

import com.app.pokedexapp.data.mapper.toDomain
import com.app.pokedexapp.data.remote.api.PokemonApi
import com.app.pokedexapp.domain.model.Pokemon
import com.app.pokedexapp.domain.repository.PokemonRepository
import jakarta.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImpl
    @Inject
    constructor(
        private val api: PokemonApi,
    ) : PokemonRepository {
        override suspend fun getPokemonList(): List<Pokemon> =
            coroutineScope {
                val response = api.getPokemonList()
                response.results
                    .map { result ->
                        // Obtenemos el id de la URL
                        val id =
                            result.url
                                .split("/")
                                .dropLast(1)
                                .last()
                        // Hacemos la llamada para obtener detalles, EN PARALELO
                        async { api.getPokemon(id).toDomain() }
                    }.awaitAll()
            }

        override suspend fun getPokemonById(id: String): Pokemon = api.getPokemon(id).toDomain()
    }
