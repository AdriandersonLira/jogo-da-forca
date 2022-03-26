package com.example.jogodaforca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var jogodaforca: JogoDaForca
    private lateinit var etLetra: EditText
    private lateinit var btn: Button
    private lateinit var btnReiniciar: Button
    private lateinit var tvPalavra: TextView
    private lateinit var tvDica: TextView
    private lateinit var tvErro: TextView
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.jogodaforca = JogoDaForca()
        this.etLetra = findViewById(R.id.etLetra)
        this.btn = findViewById(R.id.btn)
        this.btnReiniciar = findViewById(R.id.btnReiniciar)
        this.tvPalavra = findViewById(R.id.tvPalavra)
        this.tvDica = findViewById(R.id.tvDica)
        this.tvErro = findViewById(R.id.tvErro)
        this.tvStatus = findViewById(R.id.tvStatus)

        this.tvPalavra.text = this.jogodaforca.inserindoUnderline().joinToString(prefix="", postfix="", separator=" ")
        this.tvDica.text = this.jogodaforca.dica()
        this.tvErro.text = "Quant. Erros: ${this.jogodaforca.quantErro()}"
        this.tvStatus.text = "Status: ${this.jogodaforca.statusJogo()}"

        this.btn.setOnClickListener{ atualizaJogo() }
        this.btnReiniciar.setOnClickListener{ ReiniciarJogo() }
    }

    fun atualizaJogo() {
        val letra = this.etLetra.text.toString()
        this.jogodaforca.jogo(letra)
        this.tvStatus.text = "Status: ${this.jogodaforca.statusJogo()}"
        this.tvErro.text = "Quant. Erros: ${this.jogodaforca.quantErro()}"
        this.tvPalavra.text = this.jogodaforca.palavraJogo().joinToString(prefix="", postfix="", separator=" ")
    }

    fun ReiniciarJogo() {
        this.jogodaforca = JogoDaForca()
        this.tvPalavra.text = this.jogodaforca.inserindoUnderline().joinToString(prefix="", postfix="", separator=" ")
        this.tvDica.text = this.jogodaforca.dica()
        this.tvErro.text = "Quant. Erros: ${this.jogodaforca.quantErro()}"
        this.tvStatus.text = "Status: ${this.jogodaforca.statusJogo()}"
    }
}

