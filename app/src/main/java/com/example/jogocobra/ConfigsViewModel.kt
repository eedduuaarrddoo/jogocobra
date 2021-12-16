package com.example.jogocobra

import androidx.lifecycle.ViewModel

class ConfigsViewModel: ViewModel() {

    fun tabuleiroTamanho(tamanho:Int){
        _linha.value=tamanho
        _coluna.value=tamanho
}