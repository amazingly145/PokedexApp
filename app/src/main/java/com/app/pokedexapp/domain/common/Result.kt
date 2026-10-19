package com.app.pokedexapp.domain.common

// En nuestro Result
sealed class Result<out T> {
    // Loading nunca tendrá un valor de T, ni siquiera null
    object Loading : Result<Nothing>()

    // Success sí tiene un valor de tipo T
    data class Success<T>(
        val data: T,
    ) : Result<T>()

    // Error nunca tendrá un valor de T
    data class Error(
        val exception: Throwable,
    ) : Result<Nothing>()
}
/*
// <out T> solo se usa para producir/retornar valores
// Nothing se usa cuando una función nunca retorna
fun infiniteLoop(): Nothing {
    while (true) { }
}

// Nothing se usa cuando siempre lanza excepción
fun alwaysThrows(): Nothing = throw Exception("Siempre falla")
*/
