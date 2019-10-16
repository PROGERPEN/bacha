package body.hindu.shake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChtoLookingForActivity : AppCompatActivity() {

    lateinit var whoLookingFor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chto_looking_for)

        whoLookingFor = findViewById(R.id.ishesh_next_button)

        whoLookingFor.setOnClickListener {
            startActivity(Intent(this@ChtoLookingForActivity, PostRegActivity::class.java))
        }
    }
}
