package com.internshala.inventoryapp.ui.requests

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.internshala.inventoryapp.databinding.FragmentRequestsBinding
import com.internshala.inventoryapp.model.Request
import com.internshala.inventoryapp.util.ConnectionManager
import org.json.JSONException

class RequestsFragment : Fragment() {

    private var _binding: FragmentRequestsBinding? = null
    private lateinit var requestsRecyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var requestsAdapter: RequestsAdapter
    private lateinit var btnCreateRequest:FloatingActionButton
    private lateinit var progressLayout: RelativeLayout
    private lateinit var progressBar: ProgressBar

    private val requestList = arrayListOf<Request>(
        Request("1", "Mystichues", "Workshop", "Camera","3", "https://source.unsplash.com/featured/?camera"),
        Request(
            "2",
            "Electronics Club",
            "Workshop",
            "Arduino",
            "3",
            "https://source.unsplash.com/https://source.unsplash.com/random"
        ),
        Request("3", "Mystichues", "Workshop", "Camera","3", "https://source.unsplash.com/featured/?camera"),
        Request(
            "4",
            "Electronics Club",
            "Workshop",
            "Arduino",
            "3",
            "https://source.unsplash.com/https://source.unsplash.com/random"
        ),
        Request("5", "Mystichues", "Workshop", "Camera","3", "https://source.unsplash.com/featured/?camera"),
        Request(
            "1",
            "Electronics Club",
            "Workshop",
            "Arduino",
            "3",
            "https://source.unsplash.com/https://source.unsplash.com/random`"
        ),
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
    ): View {
        _binding = FragmentRequestsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requestsRecyclerView = binding.requestsRecyclerView
        btnCreateRequest = binding.btnCreateRequest
//        progressLayout = binding.progressLayout
//        progressBar = binding.progressBar
//        progressLayout.visibility = View.VISIBLE
        layoutManager = LinearLayoutManager(activity)


//        val queue = Volley.newRequestQueue(activity as Context)
//        //url of the api
//        val url = ""
//
//        if (ConnectionManager().checkConnectivity(activity as Context)) {
//            val jsonObjectRequest =
//                object : JsonObjectRequest(Method.GET, url, null, Response.Listener {
//                    //Here we will handle the response
//                    // Parsing the JSON to display the data
//                    try {
//                        progressLayout.visibility = View.GONE
//                        val success = it.getBoolean("success")
//                        if (success) {
//                            val data = it.getJSONArray("data")
//                            for (i in 0 until data.length()) {
//                                val requestJsonObject = data.getJSONObject(i)
//                                val requestObject = Request(
//                                    requestJsonObject.getString("request_id"),
//                                    requestJsonObject.getString("request_club_name"),
//                                    requestJsonObject.getString("request_event_name"),
//                                    requestJsonObject.getString("request_item_name"),
//                                    requestJsonObject.getString("request_quantity"),
//                                    requestJsonObject.getString("request_image"),
//                                )
//                                // Store it in an array
//                                requestList.add(requestObject)
//
                                requestsAdapter =
                                    RequestsAdapter(activity as Context, requestList)

                                requestsRecyclerView.adapter = requestsAdapter
                                requestsRecyclerView.layoutManager = layoutManager

                                requestsRecyclerView.addItemDecoration(
                                    DividerItemDecoration(
                                        requestsAdapter.context,
                                        (layoutManager as LinearLayoutManager).orientation
                                    )
                                )
//
//
//                            }
//                        } else {
//                            Toast.makeText(
//                                activity as Context,
//                                "Some Error Occurred",
//                                Toast.LENGTH_SHORT
//                            )
//                                .show()
//                        }
//                    } catch (e: JSONException) {
//                        Toast.makeText(
//                            activity as Context,
//                            "Some unexpected error occurred!!!",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//
//                }, Response.ErrorListener {
//                    // Here we will handle the errors
//                    // Here we will handle the errors
//                    Toast.makeText(activity as Context, "Volley error occurred", Toast.LENGTH_SHORT)
//                        .show()
//                }) {
//                    override fun getHeaders(): MutableMap<String, String> {
//                        val headers = HashMap<String, String>()
//                        headers["Content-type"] = "application/json"
//                        headers["token"] = "85f03c501b7a40"
//                        return headers
//                    }
//
//                }
////add the request
//            queue.add(jsonObjectRequest)
//        } else {
//            //Internet is not Available
//            val dialog = AlertDialog.Builder(activity as Context)
//            dialog.setTitle("Error")
//            dialog.setMessage("Internet Connection Not Found")
//            dialog.setPositiveButton("Open Settings") { text, listener ->
//                val settingsIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
//                startActivity(settingsIntent)
//                activity?.finish()
//            }
//            dialog.setNegativeButton("Exit") { text, listener ->
//                ActivityCompat.finishAffinity(activity as Activity)
//            }
//            dialog.create()
//            dialog.show()
//
//
//        }
//
//
        btnCreateRequest.setOnClickListener {
            // Respond to FAB click

        }
   }
}

