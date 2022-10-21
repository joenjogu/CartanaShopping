package com.joenjogu.cartanashopping.core.model

data class Cart(
    val __v: Int,
    val date: String,
    val id: Int,
    val products: List<CartProduct>,
    val userId: Int
)