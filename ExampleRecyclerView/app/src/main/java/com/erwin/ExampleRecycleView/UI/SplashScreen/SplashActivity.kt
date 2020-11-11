package com.erwin.ExampleRecycleView.UI.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.erwin.ExampleRecycleView.UI.Home.MainActivity
import com.erwin.ExampleRecycleView.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        
        val intent = Intent(this, MainActivity::class.java)
        handler.postDelayed({
            startActivity(intent)
        }, 2000L)
    }
}
