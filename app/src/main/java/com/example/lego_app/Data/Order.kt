package com.example.lego_app.Data

import java.util.Date

data class Order(
    val order_id : Int,
    val order_number : Int,
    val date_created : String,
    val product : List<Product>,
    val shipping : String,
    val status : String
)
