package com.ajay.pokemondex.home

import android.util.Log
import com.ajay.pokemondex.home.model.Pokemon
import com.ajay.pokemondex.home.model.Root
import com.ajay.pokemondex.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter:HomeContractor.Presenter {
    var view:HomeContractor.View?=null

    override fun attachView(view: HomeContractor.View) {
        this.view=view
        Log.d("Call","Call")
    }

    override fun detachView() {
        this.view=null
    }

    override fun getList() {
        val dataPokemon= RetrofitBuilder.getService().fetchPokemonDetails()
        dataPokemon.enqueue(object: Callback<Root> {
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                if(response.code() == 200){
                    val a:List<Pokemon> = response.body()?.pokemon as List<Pokemon>
                    view?.getPokemonList(a)
                }
            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                view?.onError("Response Failed")
            }

        })
    }

}