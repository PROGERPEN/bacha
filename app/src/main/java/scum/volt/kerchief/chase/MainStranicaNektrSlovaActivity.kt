package scum.volt.kerchief.chase

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.facebook.*
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton

class MainStranicaNektrSlovaActivity : AppCompatActivity() {

    private lateinit var facebookLogin: LoginButton


    private lateinit var callbackManager: CallbackManager

    var userEmail: String = "didn't get"
    lateinit var prefs: SharedPreferences

    lateinit var butnSignIn: Button
    lateinit var butnReg: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(applicationContext)
        setContentView(R.layout.activity_main_stranica_nektr_slova)

        AppEventsLogger.activateApp(this.application)
        facebookLogin = findViewById(R.id.reptiloid_zuk_nadoel_company_button)

        facebookLogin.setReadPermissions("email")
        prefs = getSharedPreferences("com.love.anotherdating", Context.MODE_PRIVATE)

        callbackManager = CallbackManager.Factory.create()

        butnSignIn = findViewById(R.id.sign_into_best_prilka_knopochka)
        butnReg = findViewById(R.id.create_acc_v_govne_button)

        butnSignIn.setOnClickListener {
            startActivity(Intent(this@MainStranicaNektrSlovaActivity, StranicaLolVoytiKudaActivity::class.java))
        }

        butnReg.setOnClickListener {
            startActivity(Intent(this@MainStranicaNektrSlovaActivity, AnketkaSomeWordsActivity::class.java))
        }

        LoginManager.getInstance().logOut()

        LoginManager.getInstance().registerCallback(callbackManager, object: FacebookCallback<LoginResult> {

            override fun onError(error: FacebookException?) {
                Log.d("MainStranicaNektrSlovaActivity", error.toString(), error)
            }

            override fun onCancel() {
                Toast.makeText(this@MainStranicaNektrSlovaActivity, "Авторизация отменена", Toast.LENGTH_SHORT).show()
            }

            override fun onSuccess(result: LoginResult) {
                getUserEmail(AccessToken.getCurrentAccessToken())
                if (isUserInDb()) {
                    startActivity(Intent(this@MainStranicaNektrSlovaActivity, KonechnayaSlovechkiActivity::class.java))
                } else {
                    startActivity(Intent(this@MainStranicaNektrSlovaActivity, AnketkaSomeWordsActivity::class.java))
                }
            }

        })

        facebookLogin.setOnClickListener {
            if (AccessToken.getCurrentAccessToken() == null) {
                //Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getUserEmail(token: AccessToken) {

        val request: GraphRequest = GraphRequest.newMeRequest(
            token
        ) { `object`, response ->
            Log.v("MainStranicaNektrSlovaActivity", response.toString())

            if (`object` != null) {
                userEmail = `object`.getString("email")
            }
        }

        val parameters = Bundle()
        parameters.putString("fields", "email")
        request.parameters = parameters
        request.executeAsync()
    }

    fun isUserInDb(): Boolean {
        return if (prefs.getBoolean("firstrun",true)) {
            prefs.edit().putBoolean("firstrun", false).apply()
            true
        } else {
            false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode,resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}
