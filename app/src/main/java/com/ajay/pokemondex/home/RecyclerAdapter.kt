package com.ajay.pokemondex.home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ajay.pokemondex.R
import com.ajay.pokemondex.databinding.RecyclerLayoutBinding
import com.ajay.pokemondex.details.DetailsActivity
import com.ajay.pokemondex.home.model.Pokemon
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import android.widget.Toast.makeText as makeText1

class RecyclerAdapter(var data: List<Pokemon>,private val applicationContext: Context):
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemonData = data.get(position)
        var img = pokemonData.img
        var imgArr = img?.toCharArray()
        var arrStr:String=""
        for (i in 0..imgArr?.size!!-1){
            if(imgArr[i]==':'){
                arrStr += 's'
            }
            arrStr += imgArr[i]
        }
        Glide.with(applicationContext).load(arrStr).into(holder.img)
        holder.name.text = pokemonData.name
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view),View.OnClickListener{
        var img:ImageView = view.findViewById(R.id.recyclerLayoutImg)
        var name:TextView = view.findViewById(R.id.recyclerLayoutName)
        val v = view.setOnClickListener(this)
        override fun onClick(v: View?) {
            var pokemonData:Pokemon?=data.get(adapterPosition)
            val intent: Intent = Intent(v?.context,DetailsActivity::class.java)
            intent.putExtra("pokemonDetails",pokemonData)
            v?.context?.startActivity(intent)
        }
    }
}