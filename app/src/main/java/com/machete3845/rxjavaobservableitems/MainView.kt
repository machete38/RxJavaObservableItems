package com.machete3845.rxjavaobservableitems

import com.machete3845.rxjavaobservableitems.baseMoxy.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : BaseView {
    fun setFragment(name: String)
    fun setOrderFragment(orders: List<OrderModel>)
    fun checkForUpdate()
}