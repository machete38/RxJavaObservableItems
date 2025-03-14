package com.machete3845.rxjavaobservableitems


import android.database.Observable
import retrofit2.http.GET

interface ServerApi {
    @GET("orders")
    fun getOrders(): Observable<List<OrderModel>>
}