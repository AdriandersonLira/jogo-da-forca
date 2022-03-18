package com.example.jogodaforca

import java.util.Random

class SorteioPalavra {
    private var palavras: Map<Int, Array<String>>
    private var retorno: Array<String>?

    init {
        this.palavras = mapOf(
            1 to arrayOf("Lugar aonde morar", "Casa"),
            2 to arrayOf("Instrumento Musical", "Teclado"),
            3 to arrayOf("Vestuário", "Camisa"),
            4 to arrayOf("Local aonde comer", "Mesa"),
        )

        this.retorno = main()
    }

    fun retorno(): Array<String>? {
        return retorno
    }

    fun main(): Array<String>? {
        var index = rand(1, this.palavras.size+1)
        var palavra = this.palavras?.get(index)
        return palavra
    }

    fun rand(from: Int, to: Int) : Int {
        val random = Random()
        return random.nextInt(to - from) + from // from(incluso) e to(excluso)
    }
}