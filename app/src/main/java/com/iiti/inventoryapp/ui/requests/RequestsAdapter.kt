package com.iiti.inventoryapp.ui.requests

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.iiti.inventoryapp.InventoryDetailsActivity
import com.iiti.inventoryapp.R
import com.iiti.inventoryapp.RequestDetailsActivity
import com.iiti.inventoryapp.model.Request
import com.squareup.picasso.Picasso

class RequestsAdapter(val context: Context, private val itemList: ArrayList<Request>) :
    RecyclerView.Adapter<RequestsAdapter.RequestsViewHolder>() {

    class RequestsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgRequests: ImageView = view.findViewById(R.id.imgRequests)
        val txtRequestsClubName: TextView = view.findViewById(R.id.txtRequestsClubName)
        val txtRequestsEventName: TextView = view.findViewById(R.id.txtRequestsEventName)
        val txtRequestsItemName: TextView = view.findViewById(R.id.txtRequestsItemName)
        val txtRequestsItemQuantity: TextView = view.findViewById(R.id.txtRequestsItemQuantity)
        val requestSingleRowCardItem: CardView = view.findViewById(R.id.requestsSingleRowCardItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.requests_single_row_item, parent, false)
        return RequestsViewHolder(view)

    }

    override fun onBindViewHolder(holder: RequestsViewHolder, position: Int) {
        val request = itemList[position]
        holder.txtRequestsClubName.text = request.requestClubName
        holder.txtRequestsEventName.text = request.requestEventName
        holder.txtRequestsItemName.text = "Requested : " + request.requestItemName
        holder.txtRequestsItemQuantity.text = "Qt. Required : " + request.requestItemQuantity
        Picasso.get().load(request.requestImage).error(R.drawable.ic_launcher_background)
            .into(holder.imgRequests)

        holder.requestSingleRowCardItem.setOnClickListener{
            val intent = Intent(context , RequestDetailsActivity::class.java)
            intent.putExtra("request_id" , request.requestId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}