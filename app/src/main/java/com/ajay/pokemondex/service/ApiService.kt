package com.ajay.pokemondex.service

import com.ajay.pokemondex.home.data.Root
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("pokedex.json")
    fun fetchPokemonDetails(): Call<Root>
}