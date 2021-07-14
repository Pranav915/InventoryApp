package com.internshala.inventoryapp.model

data class Request(
    val requestId:String,
    val requestClubName:String,
    val requestItemName:String,
    val requestImage:String,
    val requestItemQuantity:String
)
