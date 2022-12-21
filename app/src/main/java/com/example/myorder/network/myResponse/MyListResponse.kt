package com.example.myorder.network.myResponse

import com.google.gson.annotations.SerializedName

class MyListResponse<T> (
    @SerializedName("data")
    val data: List<T>?) : MyResponse()