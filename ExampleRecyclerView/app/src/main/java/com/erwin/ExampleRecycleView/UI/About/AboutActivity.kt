package com.erwin.ExampleRecycleView.UI.About

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erwin.ExampleRecycleView.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        fab.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6282284363365"))
            if (intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }

        }


    }
}
