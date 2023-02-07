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
package com.joenjogu.cartanashopping.core.data.model

import com.joenjogu.cartanashopping.core.database.entities.CartEntity
import com.joenjogu.cartanashopping.core.model.Cart
import com.joenjogu.cartanashopping.core.network.model.CartProduct
import com.joenjogu.cartanashopping.core.network.model.NetworkCart
import kotlin.random.Random

fun NetworkCart.asCartEntity() = CartEntity(
    id = id.toString(),
    productIDTOQuantityMap = products.map { mapOf(it.productId.toString() to it.quantity) },
    userId = userId.toString(),
    date = date
)

fun CartEntity.asCart() = Cart(
    id = id,
    productIDTOQuantityMap = productIDTOQuantityMap,
    userId = userId,
    date = date
)

fun CartEntity.asNetworkCart() = NetworkCart(
    id = id.toInt(),
    __v = Random(7).nextInt(),
    date = date,
    products = productIDTOQuantityMap.map {
        it.map { productMap ->
            CartProduct(productMap.key.toInt(), productMap.value)
        }
    }.first(),
    userId = userId.toInt()
)
