package com.example.myorder.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myorder.model.Product
import com.example.myorder.network.RetrofitInstance
import com.example.myorder.network.myResponse.MyListResponse
import com.example.myorder.network.myResponse.MyResponse
import com.example.myorder.network.product.ProductResponse
import com.example.myorder.utils.Constants
import kotlinx.coroutines.launch
import java.lang.Exception

class ListViewModel: ViewModel() {
    val productsLiveData: MutableLiveData<List<Product>> by lazy {
        MutableLiveData<List<Product>>()
    }

    init {
       getListOfProductsFromRemoteDb()
      //  deleteAllProducts()
    }

    fun getListOfProductsFromRemoteDb() {
        viewModelScope.launch {
            try {
                val response: MyListResponse<ProductResponse> =
                    RetrofitInstance.productService.getAllProducts(Constants.STUDENT_ID)
                val productsFromResponse = response.data

                if (productsFromResponse != null) {
                    val myProducts = mutableListOf<Product>()

                    for (productFromResponse in productsFromResponse) {
                        myProducts.add(
                            Product(
                                productFromResponse.id,
                                productFromResponse.title,
                                productFromResponse.price,
                                productFromResponse.description,
                                )
                        )
                    }
                    productsLiveData.value = myProducts
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    fun deleteAllProducts() {
        viewModelScope.launch {
            try {

                val response: MyResponse = RetrofitInstance.productService.deleteAllProducts(
                    Constants.STUDENT_ID
                )

                Log.d("Delete_response", response.message)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}