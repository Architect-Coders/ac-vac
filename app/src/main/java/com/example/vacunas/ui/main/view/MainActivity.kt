package com.example.vacunas.ui.main.view

import android.widget.FrameLayout
import androidx.lifecycle.Observer
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseActivity
import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.bindView
import com.example.vacunas.base.ui.visible
import com.example.vacunas.ui.blank.BlankFragment
import com.example.vacunas.ui.main.viewmodel.MainViewModel
import com.example.vacunas.ui.splash.view.SplashFragment
import com.example.vacunas.utils.Constants.Screens.SPLASH_FRAGMENT
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

    private val loadingLayout: FrameLayout by bindView(R.id.main_loading)

    //region Override BaseActivity methods
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setObservers() {
        viewModel.getViewCommand().observe(this, Observer {
            when (it) {
                is BaseViewCommand.GoTo -> {
                    val toFragment = if (it.to == SPLASH_FRAGMENT) SplashFragment() else BlankFragment()

                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(
                        R.id.main_nav_host_fragment,
                        toFragment
                    )
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
        })
    }
    //endregion

    fun toggleLoading(visible: Boolean) {
        loadingLayout.visible = visible
    }
}
