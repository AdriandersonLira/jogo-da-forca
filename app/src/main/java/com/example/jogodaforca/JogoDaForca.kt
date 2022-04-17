package com.example.jogodaforca

import java.util.*

class JogoDaForca {
    private var dica: String
    private var palavra: String
    private var tentativas: Int
    private var erros: Int
    private var palavraJogo: MutableList<String>

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

        this.tentativas = 0
        this.erros = 0
        this.palavraJogo = mutableListOf()
    }

    fun palavraJogo(): MutableList<String> {
       return palavraJogo
    }

    fun dica(): String {
        return dica
    }

    fun quantErro(): Int {
        return erros
    }

    fun inserindoUnderline(): MutableList<String> {
        for (i in palavra) {
            this.palavraJogo.add("_")
        }

        return palavraJogo
    }

    fun inserindoChar (letra: String): MutableList<String> {
        for ((index, value) in palavra.withIndex()) {
            if (letra == value.toString()) {
                palavraJogo[index] = letra
            }
        }

        return palavraJogo
    }

    fun quantLetras() : Int {
        return palavra.length
    }

    fun quantLetrasDistintas() : Int {
        var count = 0
        var palavraFun = palavra

        for ((index, value) in palavra.withIndex()) {
            if (palavraFun[index] != '_')  {
                count++
                palavraFun = palavraFun.replace(value, '_')
            }
        }

        return count
    }

    fun letraContida(value: String): Boolean {
        if (value in palavra) {
            return true
        }

        return false
    }

    fun jogo(letra: String) {
        tentativas++

        if (!letraContida(letra.toUpperCase())) erros++
        else {
            inserindoChar(letra.toUpperCase())
        }
    }

    fun statusJogo(): Boolean {
        if ("_" !in palavraJogo) return true
        return false
    }
}