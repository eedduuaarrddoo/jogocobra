package com.example.jogocobra

import android.content.Intent
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
    var cobra = Ponto()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.novojogo)
        viewmodel = ViewModelProvider(this).get(NovoJogoViewModel::class.java)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this

        var i = Intent(this, FimDjogo::class.java)


        val inflater = LayoutInflater.from(this)
        loadTabuleiro(inflater)
        viewmodel.starGame()
        fun runGame(intent : Intent) {
            Thread {
                while (viewmodel.gameStatus.value!! == true) {
                    Thread.sleep(1000  )
                    runOnUiThread {
                        viewmodel.limpaTabuleiro()

                        viewmodel.printarFruta(viewmodel.posifrutaY.value!!, viewmodel.posifrutaX.value!!)
                        viewmodel.comeuFruta(viewmodel.posifrutaY.value!!, viewmodel.posifrutaX.value!!)
                        viewmodel.gameOver()
                        viewmodel.printCobra()
                        viewmodel.moveCobra(viewmodel.direcao.value!!)



                    }
                }
                startActivity(intent)
                var bundle=Bundle()
                bundle.putString("Pontuacao",viewmodel._pontos.value!!.toString())
                intent.putExtras(bundle)
                startActivity(i)

            }.start()

        }
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
        runGame(i)

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
    }
}

