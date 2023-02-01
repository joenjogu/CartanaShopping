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

import com.joenjogu.cartanashopping.core.data.model.asUser
import com.joenjogu.cartanashopping.core.database.dao.UserDao
import com.joenjogu.cartanashopping.core.database.entities.UserEntity
import com.joenjogu.cartanashopping.core.model.User
import com.joenjogu.cartanashopping.core.network.CartanaNetworkDataSource
import com.joenjogu.cartanashopping.core.network.model.Credentials
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val networkDataSource: CartanaNetworkDataSource
) : UserRepository {
    override fun getCurrentUser(userID: String): Flow<User> {
        val userEntity = userDao.getUserEntityByID(userID = userID)
        return userEntity.map(UserEntity::asUser)
    }

    override suspend fun signInUser(username: String, password: String) {
        networkDataSource.userLogin(Credentials(username, password))
    }

    override suspend fun networkAndDBSync() {
        TODO("Not yet implemented")
    }
}
