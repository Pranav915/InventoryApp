package com.iiti.inventoryapp.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.iiti.inventoryapp.InventoryDetailsActivity
import com.iiti.inventoryapp.R
import com.iiti.inventoryapp.model.Inventory

class HomeAdapter(val context: Context, private val inventoryList: ArrayList<Inventory>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){


    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtInventoryName: TextView = view.findViewById(R.id.txtInventoryName)
        val txtInventoryAvailable: TextView = view.findViewById(R.id.txtInventoryAvailable)
        val homeSingleRowCardItem: CardView = view.findViewById(R.id.homeSingleRowCardItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_single_row_item, parent, false)
        return HomeViewHolder(view)

    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val inventory = inventoryList[position]
        holder.txtInventoryName.text = inventory.inventoryName
        holder.txtInventoryAvailable.text = "Available : ${inventory.inventoryAvailableQuantity}"

        holder.homeSingleRowCardItem.setOnClickListener{
            val intent = Intent(context , InventoryDetailsActivity::class.java)
            intent.putExtra("inventory_id" , inventory.inventoryId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return inventoryList.size
    }

}


