package com.example.jogocobra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jogocobra.databinding.ActivityMainBinding
import com.example.jogocobra.databinding.FimdjogoBinding

class FimDjogo : AppCompatActivity() {
    lateinit var binding: FimdjogoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fimdjogo)
val params=intent.extras
        val pontos= params?.getString("Pontuacao")
    binding.pontosfinal.text=pontos

       binding.voltatela.setOnClickListener {
           var i = Intent(this,MainActivity ::class.java)
           startActivity(i)
       }


    }
}