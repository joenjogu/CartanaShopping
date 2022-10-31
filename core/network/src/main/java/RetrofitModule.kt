package com.joenjogu.cartanashopping.core.network

import android.content.Context
import com.joenjogu.cartanashopping.core.network.retrofit.FakeStoreAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun providesRetrofit(
        @ApplicationContext context: Context
    ): FakeStoreAPIService = Retrofit.Builder()
        .baseUrl("")
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                )
                .build()
        )
        .addConverterFactory(

        )
        .build()
        .create(FakeStoreAPIService::class.java)
}