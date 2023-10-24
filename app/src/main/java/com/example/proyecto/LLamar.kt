package com.example.proyecto

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class LLamar : AppCompatActivity() {
    private lateinit var Boton_llamar1: Button
    private lateinit var btnatrasllamar: Button
    companion object {
        const val PHONE = "611100326"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llamar)
        initEvent()

        btnatrasllamar = this.findViewById(R.id.boton_atras_llamar)
        btnatrasllamar.setOnClickListener { view ->
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initEvent() {
        Boton_llamar1 = findViewById(R.id.Boton_llamar1)
        Boton_llamar1.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (PermissionPhone()) {
                    call()
                } else {
                    requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE)
                }
            } else {
                call()
            }
        }
    }

    private fun PermissionPhone(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun call() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$PHONE")
        startActivity(intent)
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                call()
            }
        }

}
