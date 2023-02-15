package com.joenjogu.cartanashopping.core.data.repository.fake

import com.joenjogu.cartanashopping.core.data.repository.UserRepository
import com.joenjogu.cartanashopping.core.model.User
import kotlinx.coroutines.flow.Flow

class FakeUserRepository : UserRepository {
    override fun getCurrentUser(userID: String): Flow<User> {
        TODO("Not yet implemented")
    }

    override suspend fun signInUser(username: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun networkAndDBSync() {
        TODO("Not yet implemented")
    }
}