package com.iiti.inventoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.iiti.inventoryapp.databinding.ActivityEditProfileBinding


class EditProfileActivity : AppCompatActivity() {

    private var _binding: ActivityEditProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etContactNo:EditText
    private lateinit var etDes:EditText
    private lateinit var btnRegister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityEditProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        etName = binding.etName
        etEmail = binding.etEmail
        etContactNo = binding.etContactNo
        etDes = binding.etDes
        btnRegister = binding.btnRegister

        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnRegister.setOnClickListener{performEditProfile(view)}

    }

    // Checking if the input in form is valid
    private fun validateInput(): Boolean {
        if (etName.text.toString() == "") {
            etName.error = "Please Enter Your Name"
            return false
        }
        if (etEmail.text.toString() == "") {
            etEmail.error = "Please Enter Your Email"
            return false
        }

        if (etContactNo.text.toString() == "") {
            etContactNo.error = "Please Enter Your Contact No"
            return false
        }
        if (etDes.text.toString() == "") {
            etDes.error = "Please Enter Your Designation"
            return false
        }
        // checking the proper email format
        if (!isEmailValid(etEmail.text.toString())) {
            etEmail.error = "Please Enter a Valid Email"
            return false
        }

        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Hook Click Event

    private fun performEditProfile (view: View) {
        if (validateInput()) {

            // Input is valid, here send data to your server

            val firstName = etName.text.toString()
            val email = etEmail.text.toString()
            val contactNo = etContactNo.text.toString()
            val etDes = etDes.text.toString()

            Toast.makeText(this,"Profile Update Successfully",Toast.LENGTH_SHORT).show()
            // Here you can call you API

        }
    }

}