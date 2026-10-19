package com.app.pokedexapp.domain.model

data class Pokemon(
    val id: String,
    val name: String,
    val imageUrl: String,
    val weight: Int,
    val height: Int,
    val types: List<String>,
) {
    companion object {
        fun getMockData(): List<Pokemon> =
            listOf(
                Pokemon(
                    id = "1",
                    name = "Balbasur",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                    weight = 69,
                    height = 7,
                    types = listOf("grass", "poison"),
                ),
                Pokemon(
                    id = "2",
                    name = "Ivysaur",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
                    weight = 130,
                    height = 10,
                    types = listOf("grass", "poison"),
                ),
                Pokemon(
                    id = "3",
                    name = "Venusaur",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png",
                    weight = 1000,
                    height = 20,
                    types = listOf("grass", "poison"),
                ),
                Pokemon(
                    id = "4",
                    name = "Charmander",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
                    weight = 1000,
                    height = 20,
                    types = listOf("fire"),
                ),
                Pokemon(
                    id = "5",
                    name = "Charmeleon",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png",
                    weight = 190,
                    height = 11,
                    types = listOf("fire"),
                ),
                Pokemon(
                    id = "6",
                    name = "Charizad",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
                    weight = 905,
                    height = 17,
                    types = listOf("fire", "flying"),
                ),
                Pokemon(
                    id = "7",
                    name = "Squirtle",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
                    weight = 90,
                    height = 5,
                    types = listOf("water"),
                ),
                Pokemon(
                    id = "8",
                    name = "Wartortle",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png",
                    weight = 225,
                    height = 10,
                    types = listOf("water"),
                ),
                Pokemon(
                    id = "9",
                    name = "Blastoise",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
                    weight = 855,
                    height = 16,
                    types = listOf("water"),
                ),
            )
    }
}
