package com.example.vacunas.ui.splash.view

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseFragment
import com.example.vacunas.ui.main.view.MainActivity
import com.example.vacunas.ui.splash.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<SplashViewModel>() {

    override val viewModel: SplashViewModel by viewModel()

    //region Override BaseFragment methods
    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
    }

    private fun setObservers() {
        viewModel.visibleBottomAppBar.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).toggleBottomAppBarVisibility(it)
        })

        viewModel.visibleFabButton.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).toggleFabButtonVisibility(it)
        })
    }
    //endregion
}
