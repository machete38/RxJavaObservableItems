package com.machete3845.rxjavaobservableitems.baseMoxy

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BaseView : MvpView{
    fun showLoading()
    fun hideLoading()
    fun showSnackbar(message: String)
    fun showCustomSnackbar(message: String) = Unit
}