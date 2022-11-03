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
package com.joenjogu.cartanashopping.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joenjogu.cartanashopping.core.database.dao.CartDao
import com.joenjogu.cartanashopping.core.database.dao.CategoryDao
import com.joenjogu.cartanashopping.core.database.dao.ProductDao
import com.joenjogu.cartanashopping.core.database.dao.UserDao
import com.joenjogu.cartanashopping.core.database.entities.CartEntity
import com.joenjogu.cartanashopping.core.database.entities.CategoryEntity
import com.joenjogu.cartanashopping.core.database.entities.ProductEntity
import com.joenjogu.cartanashopping.core.database.entities.UserEntity

@Database(
    entities = [
        ProductEntity::class,
        CartEntity::class,
        UserEntity::class,
        CategoryEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class CartanaDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun cartDao(): CartDao
    abstract fun userDao(): UserDao
    abstract fun categoryDao(): CategoryDao
}
