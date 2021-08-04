package com.iiti.inventoryapp

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginPage : AppCompatActivity() {

    private lateinit var loginBtn: Button
    private lateinit var forgotBtn: TextView
    private lateinit var btnSignUp: Button
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginBtn = findViewById(R.id.loginButton)
        forgotBtn = findViewById(R.id.tvForgotPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)

        loginBtn.setOnClickListener {

            //Login And Authenticate
            if (validateInput()) {
                // Input is valid, here send data to your server
                val email = etEmail.text.toString()
                val contactNo = etPassword.text.toString()

                val progressbar = Dialog(this)
                progressbar.setContentView(R.layout.progress_bar)
                progressbar.show()
                startActivity(Intent(this@LoginPage, MainActivity::class.java))
                progressbar.dismiss()
                finish()

                // Here you can call your API

                
            }
        }


        forgotBtn.setOnClickListener {
            startActivity(Intent(this@LoginPage, ForgotPasswordActivity::class.java))
        }

        btnSignUp.setOnClickListener {
            startActivity(Intent(this@LoginPage, RegistrationRequest::class.java))
        }

    }

    // Checking if the input in form is valid
    private fun validateInput(): Boolean {
        if (etEmail.text.toString() == "") {
            etEmail.error = "Please Enter Your Email"
            return false
        }

        // checking the proper email format
        if (!isEmailValid(etEmail.text.toString())) {
            etEmail.error = "Please Enter a Valid Email"
            return false
        }

        if (etPassword.text.toString() == "") {
            etPassword.error = "Please Enter Your Contact No"
            return false
        }

        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}