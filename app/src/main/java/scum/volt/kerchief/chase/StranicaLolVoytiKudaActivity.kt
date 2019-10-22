package scum.volt.kerchief.chase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StranicaLolVoytiKudaActivity : AppCompatActivity() {

    lateinit var logInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stranica_voyti_kuda)

        logInButton = findViewById(R.id.sign_into_best_prilka_knopochka)

        logInButton.setOnClickListener {
            startActivity(Intent(this@StranicaLolVoytiKudaActivity, KonechnayaSlovechkiActivity::class.java))
        }
    }
}
