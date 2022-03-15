class jogoDaForca {
    var palavra: String
    var dica: String
    var tentativas: Int
    var erros: Int
    val palavraJogo: MutableList<String>

    constructor(palavra: String, dica: String) {
        this.palavra = palavra
        this.dica = dica
        this.tentativas = 0
        this.erros = 0
        this.palavraJogo = mutableListOf()
    }

    fun inserindoUnderline (): MutableList<String> {
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

    fun jogo(letra: String): Boolean {
        tentativas++

        if (!letraContida(letra)) erros++
        else {
            inserindoChar(letra)
        }

        if (erros > 6 || "_" !in palavraJogo) return false

        return true
    }
}
