package com.iiti.inventoryapp

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.iiti.inventoryapp.databinding.ActivityAddEventRequestBinding


class AddEventRequestActivity : AppCompatActivity() {

    private var _binding: ActivityAddEventRequestBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAddEventRequestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.eventRequestActionBar)
        title = "Create Request"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //startDatePicker
        val startDatePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Event Start Date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .setCalendarConstraints(CalendarConstraints.Builder()
                    .setValidator(DateValidatorPointForward.now()).build())
                .build()
        binding.etEventStartDate.setOnClickListener {
            startDatePicker.show(supportFragmentManager, "tag")
        }
        startDatePicker.addOnPositiveButtonClickListener {
            val date = startDatePicker.headerText
            binding.etEventStartDate.text = Editable.Factory.getInstance().newEditable(date)
        }


        //endDatePicker
        val endDatePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Event End Date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .setCalendarConstraints(CalendarConstraints.Builder()
                    .setValidator(DateValidatorPointForward.now()).build())
                .build()
        binding.etEventEndDate.setOnClickListener {
            endDatePicker.show(supportFragmentManager, "tag")
        }
        endDatePicker.addOnPositiveButtonClickListener {
            val date = endDatePicker.headerText
            binding.etEventEndDate.text = Editable.Factory.getInstance().newEditable(date)
        }


        //startTimePicker
        val startTimePicker =
            MaterialTimePicker.Builder()
                .setTitleText("Select Event Start Time")
                .build()
        binding.etStartTime.setOnClickListener {
            startTimePicker.show(supportFragmentManager, "tag")
        }
        startTimePicker.addOnPositiveButtonClickListener{

            val time = if (startTimePicker.minute == 0){
                "${startTimePicker.hour}:00"
            }else{
                "${startTimePicker.hour}:${startTimePicker.minute}"
            }

            binding.etStartTime.text = Editable.Factory.getInstance().newEditable(time)
        }


        //endTimePicker
        val endTimePicker =
            MaterialTimePicker.Builder()
                .setTitleText("Select Event End Time")
                .build()
        binding.etEventEndTime.setOnClickListener {
            endTimePicker.show(supportFragmentManager, "tag")
        }
        endTimePicker.addOnPositiveButtonClickListener{
            val time = if (endTimePicker.minute == 0){
                "${endTimePicker.hour}:00"
            }else{
                "${endTimePicker.hour}:${endTimePicker.minute}"
            }
            binding.etEventEndTime.text = Editable.Factory.getInstance().newEditable(time)
        }













    }


}
