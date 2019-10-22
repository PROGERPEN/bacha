package scum.volt.kerchief.chase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WhatIsCheheshForNadoeloActivity : AppCompatActivity() {

    lateinit var whoLookingFor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_is_chehesh_for_nadoelo)

        whoLookingFor = findViewById(R.id.ishesh_next_button)

        whoLookingFor.setOnClickListener {
            startActivity(Intent(this@WhatIsCheheshForNadoeloActivity, KonechnayaSlovechkiActivity::class.java))
        }
    }
}
