package com.ajay.pokemondex.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object{
        fun getService():ApiService{
            var service = Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)

            return service
        }
    }
}