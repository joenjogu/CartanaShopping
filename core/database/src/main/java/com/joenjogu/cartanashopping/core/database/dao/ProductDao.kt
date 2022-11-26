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
package com.joenjogu.cartanashopping.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.joenjogu.cartanashopping.core.database.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductEntities(products: List<ProductEntity>)

    @Update
    suspend fun updateProductEntity(productEntity: ProductEntity)

    @Upsert
    fun upsertProductEntity(productEntity: List<ProductEntity>)

    @Query(value = "SELECT * FROM product")
    fun getProductEntities(): Flow<List<ProductEntity>>

    @Query(
        value = """
        SELECT * FROM product
        WHERE id=:id
    """
    )
    fun getProductEntityByID(id: String): Flow<ProductEntity>
}
