package com.joenjogu.cartanashopping.core.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CartCheckout(
    val date: String,
    val id: Int,
    val products: List<Product>,
    val userId: Int
)