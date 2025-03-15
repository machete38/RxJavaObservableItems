package com.machete3845.rxjavaobservableitems

import com.machete3845.rxjavaobservableitems.baseMoxy.BasePresenter
import io.reactivex.rxkotlin.subscribeBy
import moxy.InjectViewState

@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    val ordersRepository = OrdersRepository()

    fun loadOrdersPreview() {
        unsubscribeOnDestroy(
            ordersRepository.getOrders()
                .subscribeBy(
                   onSuccess = { response ->
                       if (response.isSuccessful)
                       {
                           viewState.setOrderFragment(response.body()!!)
                       }
                   },
                    onError = Throwable::printStackTrace
                )
        )
    }


}
