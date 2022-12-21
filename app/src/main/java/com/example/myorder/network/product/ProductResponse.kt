package com.example.myorder.network.product


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("color")
    val price: String,
    @SerializedName("description")
    val description: String,
)