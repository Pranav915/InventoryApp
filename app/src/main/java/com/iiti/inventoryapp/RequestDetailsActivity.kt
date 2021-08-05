package com.iiti.inventoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iiti.inventoryapp.databinding.ActivityInventoryDetailsBinding
import com.iiti.inventoryapp.databinding.ActivityRequestDetailsBinding

class RequestDetailsActivity : AppCompatActivity() {

    var requestId : String? = null
    private lateinit var binding: ActivityRequestDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.requestDetailsToolbar)
        title = getString(R.string.request_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent != null) {
            requestId = intent.getStringExtra("request_id")
        } else {
            finish()
            Toast.makeText(this, "Some unexpected error occurred", Toast.LENGTH_SHORT).show()
        }

    }
}