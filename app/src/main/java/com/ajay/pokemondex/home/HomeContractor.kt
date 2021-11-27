package com.ajay.pokemondex.home

import com.ajay.pokemondex.home.model.Pokemon


interface HomeContractor {
    interface Presenter{
        fun attachView(view: View)
        fun detachView()
        fun getList()
    }
    interface View{
        fun getPokemonList(pokemonList: List<Pokemon>)
        fun onError(msg:String)
    }
}