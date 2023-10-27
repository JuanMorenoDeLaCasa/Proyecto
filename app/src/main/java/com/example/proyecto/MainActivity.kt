package com.example.proyecto

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.net.Uri
import android.os.Build
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var btnllamar: Button
    private lateinit var intentllamar: Intent
    private lateinit var btnalarma: Button
    private lateinit var intentalarma: Intent
    private lateinit var btnurl: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnllamar = findViewById(R.id.boton_llamar)
        btnllamar.setOnClickListener { view ->
            intentllamar = Intent(this, LLamar::class.java)
            startActivity(intentllamar)
        }
        btnalarma = findViewById(R.id.boton_alarma)
        btnalarma.setOnClickListener { view ->
            intentalarma = Intent(this, Alarma::class.java)
            startActivity(intentalarma)
        }
        initEvent()
    }
    companion object {
        const val url = "https://www.aemet.es/es/eltiempo/prediccion/municipios/jaen-id23050"
    }
    private fun initEvent() {
        btnurl = findViewById(R.id.boton_url)
        btnurl.setOnClickListener {(url())
        }
    }
    private fun url(){
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

