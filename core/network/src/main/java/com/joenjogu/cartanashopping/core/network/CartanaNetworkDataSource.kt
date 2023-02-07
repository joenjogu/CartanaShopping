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
package com.joenjogu.cartanashopping.core.network

import com.joenjogu.cartanashopping.core.network.model.CartCheckout
import com.joenjogu.cartanashopping.core.network.model.Credentials
import com.joenjogu.cartanashopping.core.network.model.NetworkCart
import com.joenjogu.cartanashopping.core.network.model.NetworkCategory
import com.joenjogu.cartanashopping.core.network.model.NetworkProduct

interface CartanaNetworkDataSource {

    suspend fun getProducts(): List<NetworkProduct>

    suspend fun getProductById(id: Int): NetworkProduct

    suspend fun getCategories(): List<NetworkCategory>

    suspend fun getUserCart(userId: Int): NetworkCart

    suspend fun cartCheckout(cart: NetworkCart): CartCheckout

    suspend fun userLogin(credentials: Credentials): String
}
