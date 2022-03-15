import jogoDaForca

fun main() {
    print("Informe uma palavra: ")
    var palavra = readLine()
    print("Informe uma dica: ")
    var dica = readLine()

    var jogo = jogoDaForca(palavra.toString(), dica.toString())

    println("digite a palavra 'end' para terminar o jogo")
    println(jogo.inserindoUnderline().joinToString(prefix="[", postfix="]", separator=""))
    while (true) {
        println("quantidade de Letras: ${jogo.quantLetras()}")
        println("quantidade de Letras Distintas: ${jogo.quantLetrasDistintas()}")
        println("tentativas: ${jogo.tentativas}")
        println("erros: ${jogo.erros}")
        println("dica: ${jogo.dica}")
        print("Informe uma letra: ")
        var verifica = readLine()
        var pala = verifica.toString()

        var continua = jogo.jogo(pala)
        var apresentar =  jogo.palavraJogo.joinToString(prefix="[", postfix="]", separator="")

        println(apresentar)
        if (!continua) break
    }
}