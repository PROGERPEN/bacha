package com.gooutnow.love

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignInActivity : AppCompatActivity() {

    lateinit var logInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        logInButton = findViewById(R.id.log_in_button)

        logInButton.setOnClickListener {
            startActivity(Intent(this@SignInActivity, ClientProfileActivity::class.java))
        }
    }
}
