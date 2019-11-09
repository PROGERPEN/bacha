package meaning.torment.idyllic.swiitches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import meaning.torment.idyllic.R

class KarasMamedovActivity : AppCompatActivity() {

    lateinit var whoLookingFor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karas_mamedov)

        whoLookingFor = findViewById(R.id.bathroom_button_kok)

        whoLookingFor.setOnClickListener {
            startActivity(Intent(this@KarasMamedovActivity, ButchIsPodgeActivity::class.java))
        }
    }
}
