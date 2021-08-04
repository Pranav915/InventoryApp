package com.iiti.inventoryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.iiti.inventoryapp.databinding.ActivityAddEventRequestBinding


class AddEventRequestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEventRequestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEventRequestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.eventStartDate.setOnFocusChangeListener{view, b ->
            openDatePicker()
        }
    }

    fun openDatePicker(){
        val builder: MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker()
        val picker = builder.build()
        picker.show(this.supportFragmentManager, "DATE_PICKER")
    }
}
