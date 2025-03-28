package com.machete3845.rxjavaobservableitems.baseMoxy

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.FrameLayout
import androidx.annotation.NonNull
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.machete3845.rxjavaobservableitems.databinding.ActivityMainBinding
import com.machete3845.rxjavaobservableitems.databinding.CustomSnackbarViewBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mCompositeSubscription = CompositeDisposable()

    protected fun unsubscribeOnDestroy(@NonNull subscription: Disposable) {
        mCompositeSubscription.add(subscription)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeSubscription.clear()
    }

    fun showSnackBar(message: String, view: View) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            .show()
    }

    fun showCustomSnackbar(message: String, view: View) {

    }

    fun showLoading(view: View) {
        view.visibility = VISIBLE
    }

    fun hideLoading(view: View) {
        view.visibility = INVISIBLE
    }



    protected abstract fun showSnackbar(message: String)

    protected abstract fun showLoading()

    protected abstract fun hideLoading()

}