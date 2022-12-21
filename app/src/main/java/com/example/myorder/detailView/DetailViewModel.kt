package com.example.myorder.detailView

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myorder.model.Product
import com.example.myorder.network.RetrofitInstance
import com.example.myorder.network.myResponse.MyItemResponse
import com.example.myorder.network.myResponse.MyResponse
import com.example.myorder.network.product.ProductRequest
import com.example.myorder.network.product.ProductResponse
import com.example.myorder.utils.Constants
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailedViewModel(productId: String) : ViewModel() {

    val productLiveData: MutableLiveData<Product> by lazy {
        MutableLiveData<Product>()
    }

    init {
        getProductByIdFromRemoteDb(productId)
   //            deleteOneProductById(productId)
//                editProductById(productId,
//                    ProductRequest(
//                    "Edited brand",
//                        "Edited description",
//                        "Edited price",))
    }

    private fun getProductByIdFromRemoteDb(productId: String) {
        viewModelScope.launch {
            try {
                val response: MyItemResponse<ProductResponse> =
                    RetrofitInstance.productService.getOneProductById(productId, Constants.STUDENT_ID)
                val productFromResponse = response.data
                if (productFromResponse != null) {
                    productLiveData.value = Product(
                        productFromResponse.id,
                        productFromResponse.title,
                        productFromResponse.price,
                        productFromResponse.description
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

fun editProductById(productId: String, productRequest: ProductRequest) {
    viewModelScope.launch {
        try {

            val response: MyResponse = RetrofitInstance.productService.updateOneProductById(
                productId,
                Constants.STUDENT_ID,
                productRequest
            )

            Log.d("Update_response", response.message)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}


fun deleteOneProductById(productId: String) {
    viewModelScope.launch {
        try {

            val response: MyResponse = RetrofitInstance.productService.deleteOneProductById(
                productId,
                Constants.STUDENT_ID
            )

            Log.d("Delete_response", response.message)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
}