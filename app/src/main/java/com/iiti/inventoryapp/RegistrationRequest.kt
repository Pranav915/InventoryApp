package com.iiti.inventoryapp

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class RegistrationRequest : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etRepeatPassword: EditText
    private lateinit var etContact: EditText
    private lateinit var etClubName: EditText
    private lateinit var etDesignation: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton: RadioButton
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_request)

        viewInitializations()

        val selectedOptions = radioGroup.checkedRadioButtonId
        radioButton = findViewById(selectedOptions)

        btnRegister.setOnClickListener { performSignUp() }


    }

    private fun viewInitializations() {
        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        etRepeatPassword = findViewById(R.id.et_repeat_password)
        etContact = findViewById(R.id.et_contact_no)
        etClubName = findViewById(R.id.et_club_name)
        etDesignation = findViewById(R.id.et_des)
        radioGroup = findViewById(R.id.radioGroup)
        btnRegister = findViewById(R.id.btnRegister)


        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Checking if the input in form is valid
    private fun validateInput(): Boolean {
        if (etName.text.toString() == "") {
            etName.error = "Please Enter Your Name"
            return false
        }
        if (etEmail.text.toString() == "") {
            etEmail.error = "Please Enter Email"
            return false
        }
        if (etPassword.text.toString() == "") {
            etPassword.error = "Please Enter Password"
            return false
        }
        if (etRepeatPassword.text.toString() == "") {
            etRepeatPassword.error = "Please Repeat Your Password"
            return false
        }
        if (etContact.text.toString() == "") {
            etContact.error = "Please Enter Contact No."
            return false
        }
        if (etClubName.text.toString() == "") {
            etClubName.error = "Please Enter the Club Name"
            return false
        }
        if (etDesignation.text.toString() == "") {
            etDesignation.error = "Please Enter your Designation"
            return false
        }

        // checking the proper email format
        if (!isEmailValid(etEmail.text.toString())) {
            etEmail.error = "Please Enter Valid Email"
            return false
        }

        // checking minimum password Length
        if (etPassword.text.length < 6) {
            etPassword.error = "Password Length must be more than 6 characters"
            return false
        }

        // Checking if repeat password is same
        if (etPassword.text.toString() != etRepeatPassword.text.toString()) {
            etRepeatPassword.error = "Password does not match"
            return false
        }
        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Hook Click Event

    fun performSignUp() {
        if (validateInput()) {

            // Input is valid, here send data to your server

            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val repeatPassword = etRepeatPassword.text.toString()
            val contactNo = etContact.text.toString()
            val clubName = etClubName.text.toString()
            val designation = etDesignation.text.toString()
            val roleRequest = radioButton.text.toString()


            Toast.makeText(this , "It worked" , Toast.LENGTH_SHORT).show()

            // Here you can call your API

//            val serverAPIURL = ""
//
//
//            val queue = Volley.newRequestQueue(this)
//            val dialog: ProgressDialog? = ProgressDialog.show(this, "", "Please wait...", true)
//            val parameters: MutableMap<String, String> = HashMap()
//            // Add your parameters in HashMap
//            parameters["name"] = name
//            parameters["email"] = email
//            parameters["password"] = password
//            parameters["repeat_password"] = repeatPassword
//            parameters["contact_no"] = contactNo
//            parameters["club_name"] = clubName
//            parameters["designation"] = designation
//            parameters["role_request"] = roleRequest
//
//
//            val strReq: StringRequest = object : StringRequest(
//                Method.POST, serverAPIURL,
//                Response.Listener { response ->
//                    Log.e("response", "response: $response")
//                    dialog?.dismiss()
//
//                    // Handle Server response here
//                    try {
//                        val responseObj = JSONObject(response)
//                        val isSuccess = responseObj.getBoolean("isSuccess")
//                        val message = responseObj.getString("message")
//                        if (responseObj.has("data")) {
//                            // Handle your server response data here
//                            if (isSuccess) {
//                                Toast.makeText(this, "Check your Email for Verification" , Toast.LENGTH_SHORT).show()
//                                startActivity(Intent(this, LoginPage::class.java))
//                                finish()
//                            } else {
//                                Toast.makeText(this, message , Toast.LENGTH_LONG).show()
//                            }
//                        }
//                        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
//
//                    } catch (e: Exception) { // caught while parsing the response
//                        Log.e("exception", "problem occurred")
//                        e.printStackTrace()
//                    }
//                },
//                Response.ErrorListener { volleyError -> // error occurred
//                    Log.e("error", "problem occurred, volley error: " + volleyError.message)
//                }) {
//
//                override fun getParams(): MutableMap<String, String> {
//                    return parameters
//                }
//
//                @Throws(AuthFailureError::class)
//                override fun getHeaders(): Map<String, String> {
//
//                    // Add your Header parameters here
//
//                    return HashMap()
//                }
//            }
//            // Adding request to request queue
//            queue?.add(strReq)
        }

    }
}

