package com.joenjogu.cartanashopping.core.network

import com.joenjogu.cartanashopping.core.network.com.joenjogu.cartanashopping.core.network.model.Category
import com.joenjogu.cartanashopping.core.network.model.Cart
import com.joenjogu.cartanashopping.core.network.model.CartProduct
import com.joenjogu.cartanashopping.core.network.model.Product

interface CartanaNetworkDataSource {

    suspend fun getProducts(): List<Product>

    suspend fun getProductById(id: Int): Product

    suspend fun getCategories(): List<Category>

    suspend fun getUserCart(userId: Int): Cart

    suspend fun cartCheckout(userId: Int, date: String, cartProducts: List<CartProduct>)

    suspend fun userLogin(username: String, password: String)

}