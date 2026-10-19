package com.app.pokedexapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.pokedexapp.domain.common.Result
import com.app.pokedexapp.domain.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getPokemonListUseCase: GetPokemonListUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(HomeUiState())
        val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

        init {
            loadPokemonList()
        }

        private fun loadPokemonList() {
            viewModelScope.launch {
                getPokemonListUseCase().collect { result ->
                    _uiState.update { state ->
                        when (result) {
                            is Result.Loading -> {
                                state.copy(
                                    isLoading = true,
                                )
                            }

                            is Result.Success -> {
                                state.copy(
                                    pokemonList = result.data,
                                    isLoading = false,
                                    error = null,
                                )
                            }

                            is Result.Error -> {
                                state.copy(
                                    error = mensajeDeError(result.exception),
                                    isLoading = false,
                                )
                            }
                        }
                    }
                }
            }
        }

        private fun mensajeDeError(e: Throwable): String =
            when (e) {
                is java.io.IOException -> "Sin conexión a internet. Revisa tu red e inténtalo de nuevo."
                else -> "Ocurrió un error al cargar los Pokémon."
            }
    }
