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

import com.joenjogu.cartanashopping.core.data.model.asEntity
import com.joenjogu.cartanashopping.core.data.model.asProduct
import com.joenjogu.cartanashopping.core.database.dao.ProductDao
import com.joenjogu.cartanashopping.core.database.entities.ProductEntity
import com.joenjogu.cartanashopping.core.model.Product
import com.joenjogu.cartanashopping.core.network.model.NetworkProduct
import com.joenjogu.cartanashopping.core.network.retrofit.RetrofitNetwork
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao,
    private val networkDataSource: RetrofitNetwork
) : ProductRepository {
    override suspend fun getProducts(): Flow<List<Product>> =
        productDao.getProductEntities().map {
        it.map(ProductEntity::asProduct)
    }

    override suspend fun getProductByID(id: String): Flow<Product> {
        return productDao.getProductEntityByID(
            id
        ).map { it.asProduct() }
    }

    override suspend fun networkAndDBSync() {
        val networkProducts = networkDataSource.getProducts()
        productDao.upsertProductEntity(
            networkProducts.map {
                it.asEntity()
            }
        )
    }


}
