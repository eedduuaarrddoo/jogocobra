package com.example.jogocobra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jogocobra.databinding.ActivityConfigsBinding
import com.example.jogocobra.databinding.ListajogadorBinding

class ListaJogador : AppCompatActivity() {
    lateinit var binding: ListajogadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.listajogador)

    }
}