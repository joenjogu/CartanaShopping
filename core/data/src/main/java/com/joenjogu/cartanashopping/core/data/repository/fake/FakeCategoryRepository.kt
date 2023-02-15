package com.joenjogu.cartanashopping.core.data.repository.fake

import com.joenjogu.cartanashopping.core.data.repository.CategoryRepository
import com.joenjogu.cartanashopping.core.database.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow

class FakeCategoryRepository : CategoryRepository {
    override suspend fun getCategories(): Flow<List<CategoryEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun networkAndDBSync() {
        TODO("Not yet implemented")
    }
}