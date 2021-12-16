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
        binding.viewmodel=viewmodel
        binding.lifecycleOwner = this


            val inflater = LayoutInflater.from(this)

            for (i in 0 until viewmodel.linha.value!!) {
                for (j in 0 until viewmodel.coluna.value!!) {
                    val tv = inflater.inflate(R.layout.fundocampo, binding.gridl, false) as ImageView
                    viewmodel._tabuleiro.value!![i][j] = tv
                    binding.gridl.addView(viewmodel._tabuleiro.value!![i][j])

                }
            }
    }
            }
