package com.yourdreams.here

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChtoIsheshActivity : AppCompatActivity() {

    lateinit var whoLookingFor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chto_ishesh)

        whoLookingFor = findViewById(R.id.ishesh_next_button)

        whoLookingFor.setOnClickListener {
            startActivity(Intent(this@ChtoIsheshActivity, ProfilClientsActivity::class.java))
        }
    }
}
