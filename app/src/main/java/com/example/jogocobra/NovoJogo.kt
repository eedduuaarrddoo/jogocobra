package com.example.jogocobra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jogocobra.databinding.NovojogoBinding

class NovoJogo : AppCompatActivity() {
    lateinit var binding: NovojogoBinding
    lateinit var viewmodel: NovoJogoViewModel
    var cobra =  Ponto()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.novojogo)
        viewmodel = ViewModelProvider(this).get(NovoJogoViewModel::class.java)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this

        val inflater = LayoutInflater.from(this)

        viewmodel.listPosicaoCobra.value!!.add(Ponto(3, 5))
        loadTabuleiro(inflater)

        runGame()

        binding.cima.setOnClickListener {
            viewmodel.mudarMovimento(1)
        }
        binding.direita.setOnClickListener {
            viewmodel.mudarMovimento(4)
        }
        binding.esquerda.setOnClickListener {
            viewmodel.mudarMovimento(3)
        }
        binding.baixo.setOnClickListener {
            viewmodel.mudarMovimento(2)
        }

    }

    fun runGame() {
        Thread {
            while (true) {
                Thread.sleep(1000)
                runOnUiThread {
                    limpaTabuleiro()
                    printCobra()
                    moveCobra(viewmodel.direcao.value!!)
                }
            }
        }.start()
    }


    private fun moveCobra(movimento : Int) {
        for (i in 0 until viewmodel.listPosicaoCobra.value!!.size) {
            when(movimento){
                //cima
                1 -> viewmodel.listPosicaoCobra.value!!.get(i).x = viewmodel.listPosicaoCobra.value!!.get(i).x - 1
                //baixo
                2 -> viewmodel.listPosicaoCobra.value!!.get(i).x= viewmodel.listPosicaoCobra.value!!.get(i).x + 1
                //esquerda
                3 -> viewmodel.listPosicaoCobra.value!!.get(i).y = viewmodel.listPosicaoCobra.value!!.get(i).y - 1
                //direita
                4 -> viewmodel.listPosicaoCobra.value!!.get(i).y = viewmodel.listPosicaoCobra.value!!.get(i).y + 1
            }
        }
    }
    private fun printCobra() {
        for (i in 0 until viewmodel.listPosicaoCobra.value!!.size) {
            viewmodel._tabuleiro.value!![viewmodel.listPosicaoCobra.value!!.get(i).x][viewmodel.listPosicaoCobra.value!!.get(
                i
                                ).y]!!.setImageResource(R.drawable.komunis)
        }
    }

    private fun limpaTabuleiro() {
        for (i in 0 until viewmodel.linha.value!!) {
            for (j in 0 until (viewmodel.coluna.value!!)) {
                viewmodel._tabuleiro.value!![i][j]!!.setImageResource(R.drawable.quadradobranco)
            }
        }
    }
fun printarFruta(){
    viewmodel._tabuleiro.value!![1][1].setImageResource(R.layout.)
}
    private fun loadTabuleiro(inflater: LayoutInflater) {
        for (i in 0..(viewmodel.linha.value!! - 1)) {
            Log.i("FOR1", "pos: $i")
            for (j in 0..(viewmodel.coluna.value!! - 1)) {
                Log.i("FOR2", "pos: $i")
                val im = inflater.inflate(
                    R.layout.inflacobra,
                    binding.gridl,
                    false
                ) as ImageView
                viewmodel._tabuleiro.value!![i][j] = im
                binding.gridl.addView(viewmodel._tabuleiro.value!![i][j])
            }
        }
    } }


