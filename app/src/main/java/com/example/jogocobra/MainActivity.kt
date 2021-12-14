package com.example.jogocobra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jogocobra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.start.setOnClickListener {
            var i = Intent(this,NovoJogo ::class.java)
            startActivity(i)
        }
        binding.placar.setOnClickListener {
            var i = Intent(this,ListaJogador ::class.java)
            startActivity(i)
        }
        binding.config.setOnClickListener {
            var i = Intent(this,Configs ::class.java)
            startActivity(i)
        }



    }
}