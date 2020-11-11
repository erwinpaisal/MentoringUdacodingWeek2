package id.erwinpaisal.calculatorbmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, SelectDetails::class.java)
            startActivity(intent)
            finish()
        }, 3000)


    }
}
