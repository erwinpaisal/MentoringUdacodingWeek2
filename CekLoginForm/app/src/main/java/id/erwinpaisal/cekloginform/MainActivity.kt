package id.erwinpaisal.cekloginform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType.*
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var username : String
    lateinit var password : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun verifikasi (view: View) {
        if(checkInput(txtUsername) && checkInput(txtPassword)) {
            username = txtUsername.text.toString()
            password = txtPassword.text.toString()

            val dummyUsername = "erwin"
            val dummyPassword = "paisal"

            if (username == dummyUsername) {
                if(password == dummyPassword) {
                    var myToast = Toast.makeText(this, getString(R.string.alert_satu), Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER, 0, 500)
                    myToast.show()
                }else{
                    var myToast = Toast.makeText(this, getString(R.string.alert_dua), Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER,0, 500)
                    myToast.show()
                }
            } else {
                var myToast = Toast.makeText(this, getString(R.string.alert_tiga), Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER,0, 500)
                myToast.show()
            }
        } else {
            var myToast = Toast.makeText(this, getString(R.string.alert_lima), Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER,0, 500)
            myToast.show()
        }
    }

    private fun checkInput (et : EditText) : Boolean {
        return if (et.text.toString() != "") {
            true
        }else {
            et.error = getString(R.string.alert_enam)
            false
        }
    }

    fun showHidePassword(view: View) {
        if (cbShowPassword.isChecked)
            txtPassword.inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        else
            txtPassword.inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
    }
}