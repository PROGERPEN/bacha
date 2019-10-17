package dating.online.chatting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StranicaVoytiActivity : AppCompatActivity() {

    lateinit var logInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stranica_voyti)

        logInButton = findViewById(R.id.sign_in_knopochka)

        logInButton.setOnClickListener {
            startActivity(Intent(this@StranicaVoytiActivity, KonechnayaActivity::class.java))
        }
    }
}
