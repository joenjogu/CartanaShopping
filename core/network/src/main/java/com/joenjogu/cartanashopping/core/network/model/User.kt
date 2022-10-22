package com.joenjogu.cartanashopping.core.network.model

data class User(
    val __v: Int,
    val address: UserAddress,
    val email: String,
    val id: Int,
    val name: UserName,
    val password: String,
    val phone: String,
    val username: String
)