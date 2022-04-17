package com.example.jogodaforca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var tvResultado: TextView
    private lateinit var btnReiniciar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        this.tvResultado = findViewById(R.id.tvResultado)
        this.btnReiniciar = findViewById(R.id.btnReiniciar)

        if (intent.hasExtra("resultado")) {
            val resultado = intent.getStringExtra("resultado")

            this.tvResultado.setText(resultado)
        }

        this.btnReiniciar.setOnClickListener{
            val intent = Intent(this, GameActivity::class.java)

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}