package com.joenjogu.cartanashopping.core.network.model

data class Cart(
    val __v: Int,
    val date: String,
    val id: Int,
    val products: List<CartProduct>,
    val userId: Int
)