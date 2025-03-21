package com.machete3845.rxjavaobservableitems

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.machete3845.rxjavaobservableitems.baseMoxy.BaseActivity
import com.machete3845.rxjavaobservableitems.databinding.ActivityMainBinding
import moxy.presenter.InjectPresenter

class MainActivity : BaseActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)
    }

    override fun setFragment(name: String) {
        TODO("Not yet implemented")
    }

    override fun setOrderFragment(orders: List<OrderModel>) {
        TODO("Not yet implemented")
    }

    override fun checkForUpdate() {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun showSnackbar(message: String) {
        TODO("Not yet implemented")
    }
}