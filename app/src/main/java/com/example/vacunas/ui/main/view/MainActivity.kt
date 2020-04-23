package com.example.vacunas.ui.main.view

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseActivity
import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.setOnSimpleClickListener
import com.example.vacunas.factories.MenuItemFactory
import com.example.vacunas.ui.main.viewmodel.MainViewModel
import com.example.vacunas.utils.UiInterface
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>(), UiInterface.MainActivityContract {

    override val viewModel: MainViewModel by viewModel()

    private val navController: NavController by lazy { findNavController(R.id.navHostFragment) }

    //region Lifecycle & methods
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureBottomAppBar()
        setObservers()
        setClickListeners()
    }

    private fun configureBottomAppBar() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            MenuItemFactory.createMenuItem(it.itemId).onClick(viewModel)
            true
        }
    }

    private fun setObservers() {
        viewModel.getViewCommand().observe(this, Observer {
            when (it) {
                is BaseViewCommand.Navigate -> navigate(it.actionId, it.args)
            }
        })
    }

    private fun setClickListeners() {
        floatActionButton.setOnSimpleClickListener(viewModel::onClickFloatingActionButton)
    }
    //endregion

    fun navigate(@IdRes actionId: Int, args: Array<Pair<String, Any?>>) {
        navController.navigate(actionId, bundleOf(*args))
    }

    //region Override UiInterface.MainActivityContract methods
    override fun toggleBottomAppBarVisibility(visible: Boolean) {
        bottomAppBar.isVisible = visible
    }

    override fun toggleFabButtonVisibility(visible: Boolean) {
        floatActionButton.isVisible = visible
    }
    //endregion

    fun toggleLoading(visible: Boolean) {
        loadingView.isVisible = visible
    }
}
