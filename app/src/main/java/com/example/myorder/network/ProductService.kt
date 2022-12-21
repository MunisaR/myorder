package com.example.myorder.network

import com.example.myorder.network.myResponse.MyItemResponse
import com.example.myorder.network.myResponse.MyListResponse
import com.example.myorder.network.myResponse.MyResponse
import com.example.myorder.network.product.ProductRequest
import com.example.myorder.network.product.ProductResponse
import retrofit2.http.*

interface ProductService {
    @GET("records/all")
    suspend fun getAllProducts(
        @Query("student_id") student_id: String
    ): MyListResponse<ProductResponse>

    @GET("records/{record_id}")
    suspend fun getOneProductById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String
    ): MyItemResponse<ProductResponse>

    @POST("records")
    suspend fun insertNewProduct(
        @Query("student_id") student_id: String,
        @Body productRequest: ProductRequest
    ): MyResponse

    @PUT("records/{record_id}")
    suspend fun updateOneProductById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String,
        @Body productRequest: ProductRequest
    ): MyResponse

    @DELETE("records/{record_id}")
    suspend fun deleteOneProductById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String
    ): MyResponse

    @DELETE("records/all")
    suspend fun deleteAllProducts(
        @Query("student_id") student_id: String
    ): MyResponse
    }