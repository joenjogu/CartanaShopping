/*
 * Copyright 2023 Joe Njogu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.joenjogu.cartanashopping.core.database.converters

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi

class CartEntityConverter {

    private val moshi: Moshi = Moshi.Builder().build()
    @TypeConverter
    fun listToProductIDsJson(productIDList: List<String>): String {
        val moshi = Moshi.Builder().build()
        // TODO: get a better adapter class
        val adapter = moshi.adapter(String::class.java)
        return adapter.toJson(productIDList.toString())
    }

    @TypeConverter
    fun productIDsJsonToList(productIDsJson: String): List<String> {
        val adapter = moshi.adapter(String::class.java)
        return listOf(adapter.fromJson(productIDsJson)!!)
    }
}
