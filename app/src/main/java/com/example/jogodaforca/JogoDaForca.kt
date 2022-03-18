package com.example.jogodaforca

import java.util.*

class JogoDaForca {
    private var dica: String
    private var palavra: String

    init {
        var sorteioPalavra = SorteioPalavra()

        var palavras = sorteioPalavra.retorno()

        if (palavras != null) {
            this.dica = palavras.get(0)
            this.palavra = palavras.get(1)
        } else {
            this.dica = "Não foi possível obter a dica"
            this.palavra = "Não foi possível obter a palavra"
        }

    }

    fun palavra(): String {
       return palavra
    }

    fun dica(): String {
        return dica
    }
}