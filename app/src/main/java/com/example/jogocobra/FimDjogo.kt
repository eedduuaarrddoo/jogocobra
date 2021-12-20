package com.example.jogocobra

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
    }
}