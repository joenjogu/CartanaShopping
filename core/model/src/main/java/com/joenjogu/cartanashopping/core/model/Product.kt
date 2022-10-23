package com.joenjogu.cartanashopping.core.model

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Double,
    val ratingCount: Int,
    val title: String
)