package com.ajay.pokemondex.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajay.pokemondex.R
import com.ajay.pokemondex.databinding.ActivityDetailsBinding
import com.ajay.pokemondex.home.data.Pokemon
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pokemonDetails:Pokemon= intent.getSerializableExtra("pokemonDetails") as Pokemon;
        var img = pokemonDetails.getImg()
        var imgArr = img.toCharArray()
        var arrStr:String=""
        for (i in 0..imgArr.size-1){
            if(imgArr[i]==':'){
                arrStr += 's'
            }
            arrStr += imgArr[i]
        }
        Glide.with(applicationContext).load(arrStr).into(binding.detailsImgView)
        binding.detailsTextViewName.text = "#${pokemonDetails.getNum()} - ${pokemonDetails.getName()}"
        var strType=""
        for (i in pokemonDetails.getType()){
            strType += "$i, "
        }
        fun applyBackgroundColor() {

        }
        if(pokemonDetails.getType().contains("Grass")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_grass)
        }
        else if(pokemonDetails.getType().contains("Fire")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_fire)
        }
        else if(pokemonDetails.getType().contains("Flying")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_air)
        }
        else if(pokemonDetails.getType().contains("Electric")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_electric)
        }
        else if(pokemonDetails.getType().contains("Poison")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_poison)
        }
        else if(pokemonDetails.getType().contains("Water")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_water)
        }
        else if(pokemonDetails.getType().contains("Rock")){
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_rock)
        }
        else{
            binding.detailsActivityLayout.setBackgroundResource(R.drawable.gradient_default)
        }
        binding.detailsType.text = strType
        binding.detailsHeight.text=pokemonDetails.getHeight()
        binding.detailsWeight.text=pokemonDetails.getWeight()
        var strWeakness=""
        for(i in pokemonDetails.getWeaknesses()){
            strWeakness += "$i, "
        }
        binding.detailsWeakness.text=strWeakness

    }
}