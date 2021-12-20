package com.example.jogocobra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jogocobra.databinding.ActivityConfigsBinding

class Configs : AppCompatActivity() {
    lateinit var binding:ActivityConfigsBinding
    lateinit var viewmodel:NovoJogoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_configs)

        binding.voltabut.setOnClickListener {
            var i = Intent(this,MainActivity ::class.java)
            startActivity(i)
        }
    }
}