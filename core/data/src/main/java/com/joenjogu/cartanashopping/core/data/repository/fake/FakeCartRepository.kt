package com.joenjogu.cartanashopping.core.data.repository.fake

import com.joenjogu.cartanashopping.core.data.repository.CartRepository
import com.joenjogu.cartanashopping.core.model.Cart
import kotlinx.coroutines.flow.Flow

class FakeCartRepository : CartRepository {
    override suspend fun getUserCart(userID: String): Flow<Cart> {
        TODO("Not yet implemented")
    }

    override suspend fun cartCheckout(cart: Cart) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchNetworkUserCart(userID: String) {
        TODO("Not yet implemented")
    }
}