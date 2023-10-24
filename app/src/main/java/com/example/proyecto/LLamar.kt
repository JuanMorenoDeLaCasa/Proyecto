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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class LLamar : AppCompatActivity() {
    private lateinit var Boton_llamar1: Button

    companion object {
        const val PHONE = "112"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llamar)
        initEvent()

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
