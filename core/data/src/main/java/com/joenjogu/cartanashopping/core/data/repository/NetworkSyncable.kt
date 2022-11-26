package com.joenjogu.cartanashopping.core.data.repository

interface NetworkSyncable {

    suspend fun networkAndDBSync()
}
