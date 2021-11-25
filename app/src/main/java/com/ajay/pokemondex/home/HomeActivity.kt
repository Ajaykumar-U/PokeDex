package com.ajay.pokemondex.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajay.pokemondex.R
import com.ajay.pokemondex.databinding.ActivityHomeBinding
import com.ajay.pokemondex.home.data.Pokemon
import com.ajay.pokemondex.home.data.Root
import com.ajay.pokemondex.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(),HomeContractor.View {
    var presenter:HomeContractor.Presenter?=null
//    private lateinit var binding: ActivityHomeBinding
    lateinit var homeRecyView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter?.attachView(this)
//        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
        homeRecyView = findViewById(R.id.homeRecyclerView)
        homeRecyView.layoutManager = GridLayoutManager(this,2);

        val dataPokemon = RetrofitBuilder.getService().fetchPokemonDetails()
        dataPokemon.enqueue(object:Callback<Root>{
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                if(response.code() == 200){
                    val a:List<Pokemon> = response.body()?.getPokemon() as List<Pokemon>
                    for (i in a){
                        Log.d("HomeActivity",i.img)
                    }
                    homeRecyView.adapter = RecyclerAdapter(a,applicationContext)
                }
            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                Log.d("HomeActivity","Out")
            }

        })
    }

    override fun getPokemonList(pokemonList: List<Pokemon>) {
        homeRecyView.adapter = RecyclerAdapter(pokemonList,applicationContext)
    }

    override fun onError(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }
}

