package com.example.jogocobra


import android.content.Intent
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
    private var pontos = MutableLiveData<Int>(0)
     var _pontos: LiveData<Int> = pontos
    private var _gameStatus = MutableLiveData<Boolean>(false)
    var gameStatus: LiveData<Boolean> = _gameStatus
     var velocidade = 1
     private var tabuleiro = MutableLiveData(Array(linha.value!!) { arrayOfNulls<ImageView>(coluna.value!!) })
     var _tabuleiro: LiveData<Array<Array<ImageView?>>> = tabuleiro
     var listPosicaoCobra = MutableLiveData(mutableListOf<Ponto>())
     var _direcao = MutableLiveData<Int>(1)
     var direcao: LiveData<Int> = _direcao
     var _posifrutaX = MutableLiveData<Int>(1)
     var posifrutaX: LiveData<Int> = _posifrutaX
     var _posifrutaY = MutableLiveData<Int>(1)
     var posifrutaY: LiveData<Int> = _posifrutaY
     //jogo funções//
     fun cobraAdd(pos: Ponto) {
          listPosicaoCobra.value!!.add(pos)
     }


    fun mudarMovimento(movimento: Int) {
        _direcao.value = movimento
    }

    fun starGame(){
        _gameStatus.value = true
        listPosicaoCobra.value!!.add(Ponto((_linha.value!!/2), (_coluna.value!!/2)))
    }


    fun moveCobra(movimento: Int) {
        if (gameStatus.value!! == true)  {
            for (i in 0 until listPosicaoCobra.value!!.size) {
                when (movimento) {
                    //cima
                    1 -> listPosicaoCobra.value!!.get(0).x = listPosicaoCobra.value!!.get(0).x - 1
                    //baixo
                    2 -> listPosicaoCobra.value!!.get(0).x = listPosicaoCobra.value!!.get(0).x + 1
                    //esquerda
                    3 -> listPosicaoCobra.value!!.get(0).y = listPosicaoCobra.value!!.get(0).y - 1
                    //direita
                    4 -> listPosicaoCobra.value!!.get(0).y = listPosicaoCobra.value!!.get(0).y + 1
                }
            }
        }

    }
       fun printCobra() {
           if(gameStatus.value!! == true){
               tabuleiro.value!![listPosicaoCobra.value!!.get(0).x][listPosicaoCobra.value!!.get(0).y]!!.setImageResource(R.drawable.komunis)
           }
     }

    fun limpaTabuleiro() {
          for (i in 0 until linha.value!!) {
               for (j in 0 until (coluna.value!!)) {
                   _tabuleiro.value!![i][j]!!.setImageResource(R.drawable.quadradobranco)
               }
          }
     }
     fun printarFruta(x:Int,y:Int){
          _tabuleiro.value!![x][y]?.setImageResource(R.drawable.pao)

     }
     fun comeuFruta(x: Int, y: Int) {
         if (listPosicaoCobra.value!!.get(0).x == x && listPosicaoCobra.value!!.get(0).y == y) {
             pontos.value = pontos.value!!.plus(1)
             _posifrutaX.value = (0 until linha.value!! - 1).random()
             _posifrutaY.value = (0 until coluna.value!! - 1).random()
         }
     }
fun fimDJogo(){
if(listPosicaoCobra.value!!.get(0).x == -1 && listPosicaoCobra.value!!.get(0).y == -1){

}
}fun gameOver(){
        if ((listPosicaoCobra.value!!.get(0).x == 10 || listPosicaoCobra.value!!.get(0).y == 10) || (listPosicaoCobra.value!!.get(0).x == -1 || listPosicaoCobra.value!!.get(0).y == -1)) {
            _gameStatus.value = false
        }
    }

     }














