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
package com.joenjogu.cartanashopping.core.data

import com.joenjogu.cartanashopping.core.data.repository.CartRepository
import com.joenjogu.cartanashopping.core.data.repository.CartRepositoryImpl
import com.joenjogu.cartanashopping.core.data.repository.CategoryRepository
import com.joenjogu.cartanashopping.core.data.repository.CategoryRepositoryImpl
import com.joenjogu.cartanashopping.core.data.repository.ProductRepository
import com.joenjogu.cartanashopping.core.data.repository.ProductRepositoryImpl
import com.joenjogu.cartanashopping.core.data.repository.UserRepository
import com.joenjogu.cartanashopping.core.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsProductRepository(
        productRepository: ProductRepositoryImpl
    ): ProductRepository

    @Binds
    fun bindsCartRepository(
        cartRepository: CartRepositoryImpl
    ): CartRepository

    @Binds
    fun bindsUserRepository(
        userRepository: UserRepositoryImpl
    ): UserRepository

    @Binds
    fun bindsCategoryRepository(
        categoryRepository: CategoryRepositoryImpl
    ): CategoryRepository
}
