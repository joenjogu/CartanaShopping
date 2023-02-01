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

import com.joenjogu.cartanashopping.core.data.model.asCategoryEntity
import com.joenjogu.cartanashopping.core.database.dao.CategoryDao
import com.joenjogu.cartanashopping.core.database.entities.CategoryEntity
import com.joenjogu.cartanashopping.core.network.CartanaNetworkDataSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao,
    private val networkDataSource: CartanaNetworkDataSource
) : CategoryRepository {
    override suspend fun getCategories(): Flow<List<CategoryEntity>> =
        categoryDao.getCategoryEntities()

    override suspend fun networkAndDBSync() {
        val networkCategories = networkDataSource.getCategories()
        categoryDao.insertCategoryEntities(
            networkCategories.map { it.asCategoryEntity() }
        )
    }
}
