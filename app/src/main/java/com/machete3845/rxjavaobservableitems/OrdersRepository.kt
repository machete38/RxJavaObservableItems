package com.machete3845.rxjavaobservableitems

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response


class OrdersRepository {

    fun getOrders(): Single<Response<List<OrderModel>>> {
        return RetrofitClient.getInstance()
            .getOrderApiService()
            .getOrders()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}