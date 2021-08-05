package com.iiti.inventoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iiti.inventoryapp.databinding.ActivityInventoryDetailsBinding

class InventoryDetailsActivity : AppCompatActivity() {

    private var inventoryId : String? = null
    private lateinit var binding: ActivityInventoryDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInventoryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.inventoryDetailsToolbar)
        title = getString(R.string.inventory_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent != null) {
             inventoryId = intent.getStringExtra("book_id")
        } else {
            finish()
            Toast.makeText(this, "Some unexpected error occurred", Toast.LENGTH_SHORT).show()
        }

    }
}