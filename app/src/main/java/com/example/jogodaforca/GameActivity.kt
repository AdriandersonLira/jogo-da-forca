package com.example.jogodaforca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    private lateinit var jogodaforca: JogoDaForca
    private lateinit var etLetra: EditText
    private lateinit var btn: Button
    private lateinit var btnReiniciar: Button
    private lateinit var tvPalavra: TextView
    private lateinit var tvDica: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        this.etLetra = findViewById(R.id.etLetra)
        this.btn = findViewById(R.id.btn)
        this.btnReiniciar = findViewById(R.id.btnReiniciar)
        this.tvPalavra = findViewById(R.id.tvPalavra)
        this.tvDica = findViewById(R.id.tvDica)
        this.imageView = findViewById(R.id.imageView)

        IniciarJogo()

        this.btn.setOnClickListener{ atualizaJogo() }
        this.btnReiniciar.setOnClickListener{ IniciarJogo() }
    }

    fun atualizaJogo() {
        val letra = this.etLetra.text.toString()
        this.jogodaforca.jogo(letra)

        if (this.jogodaforca.statusJogo()) {
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("resultado", "Parabéns, você ganhou!")
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        when(this.jogodaforca.quantErro()) {
            1 -> imageView.setImageResource(R.mipmap.image_6_foreground)
            2 -> imageView.setImageResource(R.mipmap.image_5_foreground)
            3 -> imageView.setImageResource(R.mipmap.image_4_foreground)
            4 -> imageView.setImageResource(R.mipmap.image_3_foreground)
            5 -> imageView.setImageResource(R.mipmap.image_2_foreground)
            6 -> imageView.setImageResource(R.mipmap.image_1_foreground)
            7 -> {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("resultado", "Você perdeu!")
                }

                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }
        this.tvPalavra.text = this.jogodaforca.palavraJogo().joinToString(prefix="", postfix="", separator=" ")
        this.etLetra.setText("")
        this.etLetra.isFocusable()
    }

    fun IniciarJogo() {
        this.jogodaforca = JogoDaForca()
        imageView.setImageResource(R.mipmap.image_0_foreground)
        this.tvPalavra.text = this.jogodaforca.inserindoUnderline().joinToString(prefix="", postfix="", separator=" ")
        this.tvDica.text = "Dica: ${this.jogodaforca.dica()}"
    }
}