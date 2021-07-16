package com.iiti.inventoryapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iiti.inventoryapp.databinding.FragmentHomeBinding
import com.iiti.inventoryapp.model.Inventory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeRecyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var homeAdapter: HomeAdapter

    private var inventoryList = arrayListOf<Inventory>(
        Inventory("1","Camera" , "5"),
        Inventory("2", "Arduino" , "10"),
        Inventory("3", "LDR" , "20"),
        Inventory("4", "Chairs", "25"),
        Inventory("1","Camera" , "5"),
        Inventory("2", "Arduino" , "10"),
        Inventory("3", "LDR" , "20"),
        Inventory("4", "Chairs", "25"),
        Inventory("1","Camera" , "5"),
        Inventory("2", "Arduino" , "10"),
        Inventory("3", "LDR" , "20"),
        Inventory("4", "Chairs", "25"),

    )


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeRecyclerView = binding.homeRecyclerView
        layoutManager = LinearLayoutManager(activity)
        homeAdapter = HomeAdapter(activity as Context, inventoryList )
        homeRecyclerView.adapter = homeAdapter
        homeRecyclerView.layoutManager = layoutManager

        homeRecyclerView.addItemDecoration(
            DividerItemDecoration(
                homeAdapter.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}