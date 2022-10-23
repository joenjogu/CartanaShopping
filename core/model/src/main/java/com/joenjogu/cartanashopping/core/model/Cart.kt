package com.joenjogu.cartanashopping.core.model

data class Cart(
    val date: String,
    val id: Int,
    val products: List<Product>,
    val userId: Int
)