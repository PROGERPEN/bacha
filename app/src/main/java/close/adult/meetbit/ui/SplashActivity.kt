package close.adult.meetbit.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import close.adult.meetbit.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import close.adult.meetbit._core.BaseActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.onesignal.OneSignal
import kotlinx.android.synthetic.main.activity_splash.*
import org.joda.time.DateTime
import org.joda.time.Days


class SplashActivity : BaseActivity() {

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar

    private lateinit var dataSnapshot: DataSnapshot

    private lateinit var database: DatabaseReference
    val REFERRER_DATA = "REFERRER_DATA"
    val badgeCount = 1

    lateinit var prefs: SharedPreferences

    lateinit var firebaseAnalytic: FirebaseAnalytics

    override fun getContentView(): Int = R.layout.activity_web_view


    override fun initUI() {
        webView = web_view
        progressBar = progress_bar

        prefs = getSharedPreferences("body.hindu.shake", Context.MODE_PRIVATE)

        checkReturn()


        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init()

    }

    fun checkReturn() {
        if (prefs.getString("dateInstall", "") != "") {
            if (Days.daysBetween(DateTime(prefs.getString("dateInstall", "")), DateTime.now()).days == 1) {
                if (!prefs.getBoolean("rrToday", false)) {
                    prefs.edit().putString("rr", "RR").apply()
                    val rrOneBundle = Bundle()
                    rrOneBundle.putString("RR", "RR")

                    firebaseAnalytic.logEvent("RR", rrOneBundle)
                    prefs.edit().putBoolean("rrToday", true).apply()
                }
            }
        }
    }


    override fun setUI() {
        logEvent("splash-screen")
        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler?.proceed()
            }

            @SuppressLint("deprecated")
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (url.contains("/money")) {
                    val value = dataSnapshot.child(SHOW_IN).value as String

                    var taskUrl = dataSnapshot.child(TASK_URL).value.toString()

                    if (prefs.getBoolean("firstrun", true)) {
                        prefs.edit().putString("dateInstall", DateTime.now().toString()).apply()
                        prefs.edit().putBoolean("firstrun", false).apply()
                    }

                    taskUrl = prefs.getString("endurl", taskUrl).toString()

                    if (value == WEB_VIEW) {
                            startActivity(
                                    Intent(this@SplashActivity, WebViewActivity::class.java)
                                .putExtra(EXTRA_TASK_URL, taskUrl)
                            )
                        finish()
                    } else if (value == BROWSER) {
                        // launch browser with task url
                        val browserIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("")
                        )

                        logEvent("task-url-browser")
                        startActivity(browserIntent)
                        finish()
                    }
                } else if (url.contains("/main")) {
                    startActivity(Intent(this@SplashActivity, GlavnayaPhantasiyaActivity::class.java))
                    finish()
                }
                progressBar.visibility = View.GONE
                return false
            }
        }

        progressBar.visibility = View.VISIBLE


        //Яндекс метрику сюда
        val config = YandexMetricaConfig.newConfigBuilder("102ccfef-6233-405e-b3e3-c906dda46a41").build()
        YandexMetrica.activate(this, config)
        YandexMetrica.enableActivityAutoTracking(this.application)

        database = FirebaseDatabase.getInstance().reference


        getValuesFromDatabase({
            dataSnapshot = it


            // load needed url to determine if user is suitable
            webView.loadUrl(it.child(SPLASH_URL).value as String)
        }, {
            Log.d("SplashErrActivity", "didn't work fetchremote")
            progressBar.visibility = View.GONE
        })
    }
}