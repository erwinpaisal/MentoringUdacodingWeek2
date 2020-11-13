package id.erwinpaisal.kalkulatorhitungumur

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHitung.setOnClickListener {
            try {
                var tahunLahir = txtUmur.text.toString().toInt()
                var tahun: Int = Calendar.getInstance().get(Calendar.YEAR)
                var umur = tahun - tahunLahir

                if (tahunLahir > tahun) {
                    tvUmur.text = getString(R.string.tahun_tidak_valid)
                } else {
                    tvUmur.text = "Anda Berumur $umur Tahun"
                }
            } catch (e: NumberFormatException){
                Toast.makeText(this,"Harap Input Angka!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}