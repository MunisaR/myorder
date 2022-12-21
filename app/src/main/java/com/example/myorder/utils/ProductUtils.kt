package com.example.myorder.utils

import com.example.myorder.network.product.ProductResponseSizeItem

fun extractListOfSizesFromResponse(
    sizesFromResponse: List<ProductResponseSizeItem>
): List<String> {

    val mySizes = mutableListOf<String>()

    for (sizeObj in sizesFromResponse) {
        mySizes.add(sizeObj.sizeName)
    }

    return mySizes
}

fun parseSizesFromInput(
    sizesInput: String
): List<String> {
    return sizesInput.split(",")
}