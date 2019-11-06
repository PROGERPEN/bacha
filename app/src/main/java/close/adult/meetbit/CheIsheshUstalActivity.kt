package close.adult.meetbit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CheIsheshUstalActivity : AppCompatActivity() {

    lateinit var whoLookingFor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_che_ishesh_ustal)

        whoLookingFor = findViewById(R.id.ishesh_next_button)

        whoLookingFor.setOnClickListener {
            startActivity(Intent(this@CheIsheshUstalActivity, LastRtyMireaActivity::class.java))
        }
    }
}
