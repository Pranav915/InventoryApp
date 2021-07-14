package com.internshala.inventoryapp.ui.requests

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.internshala.inventoryapp.databinding.FragmentRequestsBinding
import com.internshala.inventoryapp.model.Request

class RequestsFragment : Fragment() {

    private lateinit var requestsViewModel: RequestsViewModel
    private var _binding: FragmentRequestsBinding? = null
    private lateinit var requestsRecyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var requestsAdapter: RequestsAdapter

    private val requestList = arrayListOf(
        Request("1" , "Mystichues" , "Camera", "https://source.unsplash.com/random" , "3"),
        Request("1" , "Electronics Club" , "Arduino", "https://source.unsplash.com/random" , "12" ),
        Request("1" , "Mystichues" , "Camera", "https://source.unsplash.com/random" , "3"),
        Request("1" , "Electronics Club" , "Arduino", "https://source.unsplash.com/random" , "12" ),
        Request("1" , "Mystichues" , "Camera", "https://source.unsplash.com/random" , "3"),
        Request("1" , "Electronics Club" , "Arduino", "https://source.unsplash.com/random" , "12" ),
    )

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requestsViewModel =
            ViewModelProvider(this).get(RequestsViewModel::class.java)

        _binding = FragmentRequestsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requestsRecyclerView = binding.requestsRecyclerView
        layoutManager = LinearLayoutManager(activity)
        requestsAdapter = RequestsAdapter(activity as Context, requestList)
        requestsRecyclerView.adapter = requestsAdapter
        requestsRecyclerView.layoutManager = layoutManager

        requestsRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requestsRecyclerView.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}