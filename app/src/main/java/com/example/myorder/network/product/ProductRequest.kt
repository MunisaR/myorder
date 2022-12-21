package com.example.myorder.network.product

import com.google.gson.annotations.SerializedName


data class ProductRequest(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("color")
    val price: String,
)