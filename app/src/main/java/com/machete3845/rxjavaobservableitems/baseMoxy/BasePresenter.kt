package com.machete3845.rxjavaobservableitems.baseMoxy

import androidx.annotation.NonNull
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import com.google.gson.Gson
import com.machete3845.rxjavaobservableitems.ErrorResponse
import moxy.MvpPresenter


abstract class BasePresenter<View : BaseView> : MvpPresenter<View>() {
    private val mCompositeSubscription = CompositeDisposable()

    protected fun unsubscribeOnDestroy(@NonNull subscritpion: Disposable) {
        mCompositeSubscription.add(subscritpion)

    }

    protected fun showSnackbarError(errorStringBody: String) {
        val gson = Gson()
        val errResponse = gson.fromJson(errorStringBody, ErrorResponse::class.java)
        viewState.showSnackbar(errResponse.message.orEmpty())
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeSubscription.clear()
    }
}