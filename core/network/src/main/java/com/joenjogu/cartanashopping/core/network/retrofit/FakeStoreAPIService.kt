/*
 * Copyright 2022 Joe Njogu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.joenjogu.cartanashopping.core.network.retrofit

import com.joenjogu.cartanashopping.core.network.model.CartCheckout
import com.joenjogu.cartanashopping.core.network.model.Credentials
import com.joenjogu.cartanashopping.core.network.model.NetworkCart
import com.joenjogu.cartanashopping.core.network.model.NetworkCategory
import com.joenjogu.cartanashopping.core.network.model.NetworkProduct
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FakeStoreAPIService {

    @GET("products")
    suspend fun getProducts(): Call<List<NetworkProduct>>

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): Call<NetworkProduct>

    @GET("products/categories")
    suspend fun getCategories(): Call<List<NetworkCategory>>

    @GET("carts/user/{userId}")
    suspend fun getUserCart(
        @Path("userId") userId: Int
    ): Call<NetworkCart>

    @POST("carts")
    suspend fun cartCheckout(
        @Body cart: NetworkCart
    ): Call<CartCheckout>

    @POST("auth/login")
    suspend fun userLogin(
        @Body credentials: Credentials
    ): Call<String>
}
