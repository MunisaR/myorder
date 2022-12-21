package com.example.myorder.addNew

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myorder.model.Product
import com.example.myorder.network.RetrofitInstance
import com.example.myorder.network.myResponse.MyResponse
import com.example.myorder.network.product.ProductRequest
import com.example.myorder.utils.Constants
import kotlinx.coroutines.launch

class AddNewViewModel : ViewModel() {

    val productInsertResponse: MutableLiveData<MyResponse> by lazy {
        MutableLiveData<MyResponse>()
    }

    fun saveNewProductToRemoteDb(product: ProductRequest) {

        viewModelScope.launch {
            try {

                val response: MyResponse = RetrofitInstance.productService.insertNewProduct(
                    Constants.STUDENT_ID,
                    product
                )

                productInsertResponse.value = response

                Log.d("Update_response", response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}