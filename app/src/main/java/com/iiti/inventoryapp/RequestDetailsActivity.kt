package com.iiti.inventoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class RequestDetailsActivity : AppCompatActivity() {

    var requestId : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_details)

        if (intent != null) {
            requestId = intent.getStringExtra("request_id")
        } else {
            finish()
            Toast.makeText(this, "Some unexpected error occurred", Toast.LENGTH_SHORT).show()
        }

    }
}