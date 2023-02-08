package com.joenjogu.cartanashopping.core.network.fake

import com.joenjogu.cartanashopping.core.network.CartanaNetworkDataSource
import com.joenjogu.cartanashopping.core.network.model.CartCheckout
import com.joenjogu.cartanashopping.core.network.model.Credentials
import com.joenjogu.cartanashopping.core.network.model.NetworkCart
import com.joenjogu.cartanashopping.core.network.model.NetworkCategory
import com.joenjogu.cartanashopping.core.network.model.NetworkProduct

class FakeCartanaNetworkDataSource : CartanaNetworkDataSource {
    override suspend fun getProducts(): List<NetworkProduct> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductById(id: Int): NetworkProduct {
        TODO("Not yet implemented")
    }

    override suspend fun getCategories(): List<NetworkCategory> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserCart(userId: Int): NetworkCart {
        TODO("Not yet implemented")
    }

    override suspend fun cartCheckout(cart: NetworkCart): CartCheckout {
        TODO("Not yet implemented")
    }

    override suspend fun userLogin(credentials: Credentials): String {
        TODO("Not yet implemented")
    }
}