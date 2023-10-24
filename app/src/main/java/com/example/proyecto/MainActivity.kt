package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnllamar: Button
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnllamar = findViewById(R.id.boton_llamar)
        btnllamar.setOnClickListener { view ->
            intent = Intent(this, LLamar::class.java)
            startActivity(intent)
        }
    }
}
