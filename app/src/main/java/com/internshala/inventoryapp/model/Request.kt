package com.internshala.inventoryapp.model

data class Request(
    val requestId:String,
    val requestClubName:String,
    val requestEventName:String,
    val requestItemName:String,
    val requestItemQuantity:String,
    val requestImage:String,
)
