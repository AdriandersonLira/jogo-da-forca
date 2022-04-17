package com.example.jogodaforca

import java.util.Random

class SorteioPalavra {
    private var palavras: Map<Int, Array<String>>
    private var retorno: Array<String>?

    init {
        this.palavras = mapOf(
            1 to arrayOf("Instrumento Musical", "CAJON"),
            2 to arrayOf("Instrumento Musical", "TECLADO"),
            3 to arrayOf("Vestuário", "CAMISA"),
            4 to arrayOf("Local aonde comer", "LANCHONETE"),
            5 to arrayOf("Estado", "TOCANTINS"),
            6 to arrayOf("Profissão", "JUIZ"),
            7 to arrayOf("Animal", "LEOPARDO"),
            8 to arrayOf("Objeto, Congelado", "FREEZER"),
            9 to arrayOf("Móvel de cozinha", "GELADEIRA"),
            10 to arrayOf("Fruta", "KIWI"),
            11 to arrayOf("Fruta", "PERA"),
            12 to arrayOf("Vestuário", "MOLETOM"),
            13 to arrayOf("Estado", "MARANHAO"),
            14 to arrayOf("Objeto", "DESFIBRILADOR"),
            15 to arrayOf("Periférico de computador", "WEBCAM"),
            16 to arrayOf("Ação, Ligar", "ACENDER"),
            17 to arrayOf("Esporte", "BASQUETE"),
            18 to arrayOf("Tipo de Tecido", "JEANS"),
            19 to arrayOf("Objeto, Cozinha", "FACA"),
            20 to arrayOf("Médico, Olhos", "OFTALMOLOGISTA"),
            21 to arrayOf("Profissão", "REPORTER"),
            22 to arrayOf("Jogo da", "FORCA"),
            23 to arrayOf("Local, Casa", "BANHEIRO"),
            24 to arrayOf("Doença", "CATAPORA"),
            25 to arrayOf("Fruta", "ABACAXI"),
            26 to arrayOf("Fruta", "MELANCIA"),
            27 to arrayOf("País", "INGLATERRA"),
            28 to arrayOf("Cidade, EUA", "ORLANDO"),
            29 to arrayOf("Marca, Carro", "AUDI"),
            30 to arrayOf("Marca, Carro", "CHEVROLET"),
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