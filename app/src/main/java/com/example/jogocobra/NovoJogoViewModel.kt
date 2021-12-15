package com.example.jogocobra

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.reflect.Array

class NovoJogoViewModel: ViewModel()  {
     var _linha = MutableLiveData<Int>(20)
     var linha: LiveData<Int> = _linha
     var _coluna = MutableLiveData<Int>(20)
     var coluna: LiveData<Int> = _coluna
     private var _tabuleiro=MutableLiveData(Array(linha.value!!){IntArray(coluna.value!!)})






}