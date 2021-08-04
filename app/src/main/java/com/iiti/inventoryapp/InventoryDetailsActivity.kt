package com.iiti.inventoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class InventoryDetailsActivity : AppCompatActivity() {

    private var inventoryId : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory_details)

        if (intent != null) {
             inventoryId = intent.getStringExtra("book_id")
        } else {
            finish()
            Toast.makeText(this, "Some unexpected error occurred", Toast.LENGTH_SHORT).show()
        }

    }
}