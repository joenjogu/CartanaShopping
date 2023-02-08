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
import com.joenjogu.cartanashopping.core.network.model.CartCheckout
import com.joenjogu.cartanashopping.core.network.model.Credentials
import com.joenjogu.cartanashopping.core.network.model.NetworkCart
import com.joenjogu.cartanashopping.core.network.model.NetworkCategory
import com.joenjogu.cartanashopping.core.network.model.NetworkProduct
import javax.inject.Inject
import retrofit2.awaitResponse

class RetrofitNetwork @Inject constructor(
    private val apiService: FakeStoreAPIService
) : CartanaNetworkDataSource {

    override suspend fun getProducts(): List<NetworkProduct> = withRetry {
        apiService.getProducts()
            .awaitResponse()
            .bodyOrThrow()
    }

    override suspend fun getProductById(id: Int): NetworkProduct = withRetry {
        apiService.getProductById(id = id)
            .awaitResponse()
            .bodyOrThrow()
    }

    override suspend fun getCategories(): List<NetworkCategory> = withRetry {
        apiService.getCategories()
            .awaitResponse()
            .bodyOrThrow()
    }

    override suspend fun getUserCart(userId: Int): NetworkCart = withRetry {
        apiService.getUserCart(userId = userId)
            .awaitResponse()
            .bodyOrThrow()
    }

    override suspend fun cartCheckout(cart: NetworkCart): CartCheckout = withRetry {
        apiService.cartCheckout(cart = cart)
            .awaitResponse()
            .bodyOrThrow()
    }

    override suspend fun userLogin(credentials: Credentials): String = withRetry {
        // TODO: Better Network Handling for Auth Token
        apiService.userLogin(credentials = credentials)
            .awaitResponse()
            .bodyOrThrow()
    }
}
