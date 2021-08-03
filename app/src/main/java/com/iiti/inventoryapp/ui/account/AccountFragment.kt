package com.iiti.inventoryapp.ui.account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iiti.inventoryapp.EditProfileActivity
import com.iiti.inventoryapp.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private lateinit var editProfileCardView:CardView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        editProfileCardView = binding.editProfileCardView

        editProfileCardView.setOnClickListener {
            val intent = Intent(activity as Context , EditProfileActivity::class.java)
            startActivity(intent)
         }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}