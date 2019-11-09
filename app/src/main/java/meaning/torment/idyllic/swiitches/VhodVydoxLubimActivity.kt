package meaning.torment.idyllic.swiitches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import meaning.torment.idyllic.R

class VhodVydoxLubimActivity : AppCompatActivity() {

    lateinit var logInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vhod_vyhod_lubim)

        logInButton = findViewById(R.id.mojet_da_a_mojet_button)

        logInButton.setOnClickListener {
            startActivity(Intent(this@VhodVydoxLubimActivity, ButchIsPodgeActivity::class.java))
        }
    }
}
