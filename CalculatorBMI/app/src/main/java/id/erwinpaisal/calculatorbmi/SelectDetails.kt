package id.erwinpaisal.calculatorbmi

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_select_details.*

class SelectDetails : AppCompatActivity() {

    private lateinit var viewModel: SelectViewModel

    private var priaCheck: Boolean = true
    private var check1: Boolean = true
    private var wanitaCheck: Boolean = true
    private var check2: Boolean = true

    private var countBerat: Int = 50
    private var countUsia: Int = 18

    var tinggi: Float = 0.0F
    private var BMI: Float = 0.0F

    private lateinit var slider: SeekBar

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_details)

        viewModel = ViewModelProviders.of(this).get(SelectViewModel::class.java)

        slider = findViewById(R.id.Seekbar)
        cvPria.setOnClickListener {
            if (check1) {
                if (priaCheck) {
                    tvPria.setTextColor(Color.parseColor("#FFFFFF"))
                    tvPria.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.male_white,
                            0,
                            0
                    )
                    priaCheck = false
                    check2 = false
                } else {
                    tvPria.setTextColor(Color.parseColor("#8D8E99"))
                    tvPria.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.male, 0, 0)
                    priaCheck = true
                    check2 = true
                }
            }
        }

        cvWanita.setOnClickListener { //Your code here
            if (check2) {
                if (wanitaCheck) {
                    tvWanita.setTextColor(Color.parseColor("#FFFFFF"))
                    tvWanita.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.female_white,
                            0,
                            0
                    )
                    wanitaCheck = false
                    check1 = false
                } else {
                    tvWanita.setTextColor(Color.parseColor("#8D8E99"))
                    tvWanita.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.female,
                            0,
                            0
                    )
                    wanitaCheck = true
                    check1 = true
                }
            }
        }

        berat_plus.setOnClickListener {
            countBerat++
            tvBerat.text = countBerat.toString()
        }

        berat_minus.setOnClickListener {
            countBerat--
            tvBerat.text = countBerat.toString()
        }

        slider.max = 200
        checkHeight()

        usia_plus.setOnClickListener {
            countUsia++
            tvUsia.text = countUsia.toString()
        }
        usia_minus.setOnClickListener {
            countUsia--
            tvUsia.text = countUsia.toString()
        }

        btnHitung.setOnClickListener {
            hitungBMI()
        }
    }

    private fun checkHeight() {
        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvTinggi.text = progress.toString()
                tinggi = ((progress / 100).toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                tvTinggi.text = seekBar?.progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                tvTinggi.text = seekBar?.progress.toString()
            }
        })
    }

    private fun hitungBMI() {
        val finalBerat = tvBerat.text.toString().toFloat()
        val finalTinggi = tvTinggi.text.toString().toFloat()
        val finalUsia = tvUsia.text.toString()
        BMI = ((finalBerat / (finalTinggi * finalTinggi)) * 10000)
        val intent = Intent(this, Result::class.java)
        intent.putExtra("bmi", BMI)
        intent.putExtra("usia", finalUsia)
        startActivity(intent)
    }
}