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

import com.joenjogu.cartanashopping.core.network.CartanaNetworkDataSource
import com.joenjogu.cartanashopping.core.network.com.joenjogu.cartanashopping.core.network.model.Credentials
import com.joenjogu.cartanashopping.core.network.model.Cart
import com.joenjogu.cartanashopping.core.network.model.Category
import com.joenjogu.cartanashopping.core.network.model.Product

class RetrofitNetwork(private val apiService: FakeStoreAPIService) : CartanaNetworkDataSource {
    override suspend fun getProducts(): List<Product> {
        withRetry {
            apiService.getProducts()
        }
    }

    override suspend fun getProductById(id: Int): Product {
        TODO("Not yet implemented")
    }

    override suspend fun getCategories(): List<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserCart(userId: Int): Cart {
        TODO("Not yet implemented")
    }

    override suspend fun cartCheckout(cart: Cart) {
        TODO("Not yet implemented")
    }

    override suspend fun userLogin(credentials: Credentials): String {
        TODO("Not yet implemented")
    }
}