package com.joenjogu.cartanashopping.core.model

data class UserAddress(
    val city: String,
    val geolocation: UserGeolocation,
    val number: Int,
    val street: String,
    val zipcode: String
)