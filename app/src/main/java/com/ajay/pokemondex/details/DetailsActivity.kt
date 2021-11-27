package com.ajay.pokemondex.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajay.pokemondex.R
import com.ajay.pokemondex.databinding.ActivityDetailsBinding
import com.ajay.pokemondex.home.model.Pokemon
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pokemonDetails:Pokemon= intent.getSerializableExtra("pokemonDetails") as Pokemon;
        var img = pokemonDetails.img
        var imgArr = img?.toCharArray()
        var arrStr:String=""
        for (i in 0..imgArr?.size!!-1){
            if(imgArr[i]==':'){
                arrStr += 's'
            }
            arrStr += imgArr[i]
        }
        Glide.with(applicationContext).load(arrStr).into(binding.detailsImgView)
        binding.detailsTextViewName.text = "#${pokemonDetails.num} - ${pokemonDetails.name}"
        var strType=""
        for (i in pokemonDetails?.type!!){
            strType += "$i, "
        }
        if(pokemonDetails?.type!!.contains("Grass")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_grass)
        }
        else if(pokemonDetails.type!!.contains("Fire")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_fire)
        }
        else if(pokemonDetails.type!!.contains("Flying")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_air)
        }
        else if(pokemonDetails.type!!.contains("Electric")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_electric)
        }
        else if(pokemonDetails.type!!.contains("Poison")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_poison)
        }
        else if(pokemonDetails.type!!.contains("Water")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_water)
        }
        else if(pokemonDetails.type!!.contains("Rock")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_rock)
        }
        else{
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_default)
        }
        binding.detailsType.text = strType
        binding.detailsHeight.text=pokemonDetails.height
        binding.detailsWeight.text=pokemonDetails.weight
        var strWeakness=""
        for(i in pokemonDetails.weaknesses!!){
            strWeakness += "$i, "
        }
        binding.detailsWeakness.text=strWeakness
    }
}