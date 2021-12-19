package com.example.jogocobra

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NovoJogoViewModel: ViewModel() {
     //jogovariaveis//
     var _linha = MutableLiveData<Int>(10)
     var linha: LiveData<Int> = _linha
     var _coluna = MutableLiveData<Int>(10)
     var coluna: LiveData<Int> = _coluna


     var pontos = 1
     var inGame = true
     var velocidade = 1
     private var tabuleiro =
          MutableLiveData(Array(linha.value!!) { arrayOfNulls<ImageView>(coluna.value!!) })
     var _tabuleiro: LiveData<Array<Array<ImageView?>>> = tabuleiro
     var listPosicaoCobra = MutableLiveData(mutableListOf<Ponto>())
     var _direcao = MutableLiveData<Int>(1)
     var direcao: LiveData<Int> = _direcao

     //jogo funções//
     fun cobraAdd(pos: Ponto) {
          listPosicaoCobra.value!!.add(pos)
     }


     fun mudarMovimento(movimento : Int){
          _direcao.value = movimento
     }
}







