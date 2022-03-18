package com.example.jogodaforca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var jogodaforca: JogoDaForca
    private lateinit var textoPalavra: TextView
    private lateinit var textoDica: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.jogodaforca = JogoDaForca()
        this.textoPalavra = findViewById(R.id.tvPalavra)
        this.textoDica = findViewById(R.id.tvDica)

        this.textoPalavra.text = this.jogodaforca.palavra()
        this.textoDica.text = this.jogodaforca.dica()
    }
}

