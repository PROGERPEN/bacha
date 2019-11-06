package close.adult.meetbit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PageVhodCheKekActivity : AppCompatActivity() {

    lateinit var logInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_vhod_che_kek)

        logInButton = findViewById(R.id.vhod_eto_ad)

        logInButton.setOnClickListener {
            startActivity(Intent(this@PageVhodCheKekActivity, LastRtyMireaActivity::class.java))
        }
    }
}
