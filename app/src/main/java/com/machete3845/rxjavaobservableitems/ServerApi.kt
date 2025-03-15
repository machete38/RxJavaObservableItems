package com.machete3845.rxjavaobservableitems



import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response

import retrofit2.http.GET

interface ServerApi {
    @GET("orders")
    fun getOrders(): Single<Response<List<OrderModel>>>
}