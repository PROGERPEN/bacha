package com.yourdreams.here

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class VoytiActivity : AppCompatActivity() {

    lateinit var logInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voyti)

        logInButton = findViewById(R.id.vhod_button)

        logInButton.setOnClickListener {
            startActivity(Intent(this@VoytiActivity, ProfilClientsActivity::class.java))
        }
    }
}
