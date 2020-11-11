package id.erwinpaisal.kalkulatorhitungumur

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHitung.setOnClickListener {
            val tahunLahir = txtUmur.text.toString()
            val tahun: Int = Calendar.getInstance().get(Calendar.YEAR)
                        if (tahunLahir.toIntOrNull() != null) {
                val umur = tahun - tahunLahir.toInt()
                tvUmur.text = "Umur Anda = $umur Tahun"
            } else {
                tvUmur.text = getString(R.string.tahun_tidak_valid)
            }
        }
    }
}