package com.erwin.ExampleListView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail_binatang.*

class DetailBinatang : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_binatang)

        val bundle = intent.extras

        ivBinatang.setImageResource(bundle!!.getInt("gambar"))
        tvNama.text = bundle.getString("nama")
        tvDeskripsi.text = bundle.getString("deskripsi")

        val titlebar = findViewById<TextView>(R.id.toolbarTittle)
        titlebar.setText("Halaman Detail")

        val btnHome = findViewById<ImageButton>(R.id.toolbarHome)
        btnHome.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.toolbarHome -> {
                val moveIntent = Intent(this@DetailBinatang, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
