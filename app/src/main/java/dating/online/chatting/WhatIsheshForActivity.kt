package dating.online.chatting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WhatIsheshForActivity : AppCompatActivity() {

    lateinit var whoLookingFor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_ishesh_for)

        whoLookingFor = findViewById(R.id.ishesh_next_button)

        whoLookingFor.setOnClickListener {
            startActivity(Intent(this@WhatIsheshForActivity, KonechnayaActivity::class.java))
        }
    }
}
