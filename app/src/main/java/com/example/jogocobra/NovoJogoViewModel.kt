package com.example.jogocobra

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.reflect.Array
import kotlin.concurrent.thread
import kotlin.collections.MutableList as MutableLis

class NovoJogoViewModel: ViewModel()  {
     var _linha = MutableLiveData<Int>(10)
     var linha: LiveData<Int> = _linha
     var _coluna = MutableLiveData<Int>(10)
     var coluna: LiveData<Int> = _coluna

//jogovariaveis//
     var pontos=1
     var inGame=true
     var velocidade=1
     var _tabuleiro=MutableLiveData(Array(linha.value!!){ arrayOfNulls<ImageView>(coluna.value!!) })
//jogo funções//


  }




}





