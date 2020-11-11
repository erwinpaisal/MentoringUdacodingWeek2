package id.erwinpaisal.calculatorbmi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {


    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val bmi = intent.getFloatExtra("bmi", 0.0F)

        val age = intent.getStringExtra("usia")
        your_bmi.text = "%.1f".format(bmi)
        tvUsia.text = age.toString()

        when (bmi) {
            in 0.0..18.5 -> {
                kondisi?.setTextColor(getColor(R.color.red))
                kondisi.text = "Berat badan kurang"
            }
            in 18.5..24.9 -> {
                kondisi?.setTextColor(getColor(R.color.green))
                kondisi.text = "Normal"
            }
            in 25.0..29.9 -> {
                kondisi?.setTextColor(getColor(R.color.yellow))
                kondisi.text = "Kegemukan"
            }
            in 30.0..Float.MAX_VALUE.toDouble() -> {
                kondisi?.setTextColor(getColor(R.color.orange))
                kondisi.text = "Obesitas"
            }
        }

        btnHitungUlang.setOnClickListener {
            val intent = Intent(this, SelectDetails::class.java)
            startActivity(intent)

        }

    }
}