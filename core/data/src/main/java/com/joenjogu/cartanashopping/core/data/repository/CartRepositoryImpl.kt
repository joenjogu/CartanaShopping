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
package com.joenjogu.cartanashopping.core.data.repository

import com.joenjogu.cartanashopping.core.data.model.asCart
import com.joenjogu.cartanashopping.core.data.model.asCartEntity
import com.joenjogu.cartanashopping.core.database.dao.CartDao
import com.joenjogu.cartanashopping.core.model.Cart
import com.joenjogu.cartanashopping.core.network.CartanaNetworkDataSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao,
    private val networkDataSource: CartanaNetworkDataSource
) : CartRepository {
    override suspend fun getUserCart(userID: String): Flow<Cart> {
        return cartDao.getCartEntityByID(networkCart.id.toString()).map { it.asCart() }
    }

    override fun cartCheckout(cart: Cart) {
        val cartEntity = cartDao.getCartEntityByID(cart.id)
        networkDataSource.cartCheckout(cartEntity.map { it.asCart() })
    }

    override fun insertCart(cart: Cart) {
        cartDao.insertCartEntity(cart.asEntity())
    }

    override fun updateCart(cart: Cart) {
        cartDao.updateCartEntity(cart.asEntity())
    }
}
