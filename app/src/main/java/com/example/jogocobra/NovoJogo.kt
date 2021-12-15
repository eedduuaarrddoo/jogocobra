package com.example.jogocobra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jogocobra.databinding.ActivityConfigsBinding
import com.example.jogocobra.databinding.NovojogoBinding

class NovoJogo : AppCompatActivity() {
    lateinit var binding: NovojogoBinding
    lateinit var viewmodel:NovoJogoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.novojogo)
        viewmodel = ViewModelProvider(this).get(NovoJogoViewModel::class.java)

        binding.lifecycleOwner = this

        for (i in 0..2499){
            val inflater = LayoutInflater.from(this)
            val tv = inflater.inflate(R.layout.fundocampo,binding.gridL, false) as ImageView
        binding.gridL.addView(tv)

    }
        binding.gridL.columnCount= viewmodel.coluna.value!!
        binding.gridL.rowCount= viewmodel.linha.value!!
       // binding.testador.setOnClickListener {
           // binding.apply {


            //}
       // }
  }
    }