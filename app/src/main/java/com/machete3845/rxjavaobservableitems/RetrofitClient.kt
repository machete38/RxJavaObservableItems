package com.machete3845.rxjavaobservableitems

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient{

    val retrofit: Retrofit

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun getOrderApiService(): ServerApi{
        return retrofit.create(ServerApi::class.java)
    }

    companion object
    {
        val baseUrl = "https://67d2d82490e0670699bf5997.mockapi.io"

        @Volatile
        var instance: RetrofitClient? = null
        fun getInstance(): RetrofitClient
        {
            if (instance == null)
            {
                instance = RetrofitClient()
            }
            return instance ?: RetrofitClient().also { instance = it }
            }
        }
    }
