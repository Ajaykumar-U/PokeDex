package com.ajay.pokemondex.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajay.pokemondex.R
import com.ajay.pokemondex.home.model.Pokemon

class HomeActivity : AppCompatActivity(),HomeContractor.View {
    var presenter:HomeContractor.Presenter?= HomePresenter()
    lateinit var homeRecyView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Call","HomeCall")
        presenter?.attachView(this)
        presenter?.getList()
        setContentView(R.layout.activity_home)
        homeRecyView = findViewById(R.id.homeRecyclerView)
        homeRecyView.layoutManager = GridLayoutManager(this,2);
    }

    override fun getPokemonList(pokemonList: List<Pokemon>) {
        homeRecyView.adapter = RecyclerAdapter(pokemonList,applicationContext)
    }

    override fun onError(msg: String) {
        Toast.makeText(applicationContext,"Error: Please check network connectivity",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }
}
