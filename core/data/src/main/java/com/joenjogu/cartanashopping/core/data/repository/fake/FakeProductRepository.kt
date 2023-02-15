package com.joenjogu.cartanashopping.core.data.repository.fake

import com.joenjogu.cartanashopping.core.data.repository.ProductRepository
import com.joenjogu.cartanashopping.core.model.Product
import kotlinx.coroutines.flow.Flow

class FakeProductRepository : ProductRepository {
    override suspend fun getProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductByID(id: String): Flow<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun networkAndDBSync() {
        TODO("Not yet implemented")
    }
}