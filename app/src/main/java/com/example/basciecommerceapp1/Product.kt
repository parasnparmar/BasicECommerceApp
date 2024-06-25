package com.example.basciecommerceapp1

import java.io.Serializable

data class Product(var title: String,
                   var price: Double,
                   var description: String,
                   var image: Int) : Serializable
