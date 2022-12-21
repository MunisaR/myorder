package com.example.myorder.network.product

import com.google.gson.annotations.SerializedName

data class ProductResponseSizeItem(
    @SerializedName("id")
    val sizeEntryId: String,
    @SerializedName("record_id")
    val sizeRecordId: String,
    @SerializedName("value")
    val sizeName: String,
)