package com.iiti.inventoryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    lateinit var btn_login : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        viewInitializations()

        btn_login.setOnClickListener {
            startActivity(Intent(this , LoginPage::class.java))
            finish()
        }

    }

    private fun viewInitializations() {

        etEmail = findViewById(R.id.et_email)
        btn_login = findViewById(R.id.btn_login)

        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun validateInput(): Boolean {

        if (etEmail.text.toString() == "") {
            etEmail.error = "Please Enter Email"
            return false
        }
        // checking the proper email format
        if (!isEmailValid(etEmail.text.toString())) {
            etEmail.error = "Please Enter Valid Email"
            return false
        }
        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return EMAIL_ADDRESS.matcher(email).matches()
    }

    fun performForgetPassword (view: View) {
        if (validateInput()) {

            // Input is valid, here send data to your server


            val email = etEmail.text.toString()

            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)

            Toast.makeText(this,"Email send to Registered Email Address", Toast.LENGTH_SHORT).show()


            // Here you can call you API

        }
    }


}
