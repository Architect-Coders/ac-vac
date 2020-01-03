package com.example.vacunas.ui.splash.view

import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseFragment
import com.example.vacunas.ui.splash.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<SplashViewModel>() {

    override val viewModel: SplashViewModel by viewModel()

    //region Override BaseFragment methods
    override fun getLayoutId(): Int = R.layout.fragment_splash
    //endregion
}
