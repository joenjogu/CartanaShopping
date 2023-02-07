package com.joenjogu.cartanashopping.core.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "productId")
    val productId: Int,
    @Json(name = "quantity")
    val quantity: Int
)