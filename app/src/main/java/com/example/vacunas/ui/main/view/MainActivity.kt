package com.example.vacunas.ui.main.view

import android.os.Bundle
import android.widget.FrameLayout
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseActivity
import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.bindView
import com.example.vacunas.base.ui.visible
import com.example.vacunas.data.factories.MenuItemFactory
import com.example.vacunas.ui.main.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

    private val loadingLayout: FrameLayout by bindView(R.id.main_loading)
    private val bottomNavigation: BottomNavigationView by bindView(R.id.main_bottomNavigation)

    private val navController: NavController by lazy { findNavController(R.id.main_nav_host_fragment) }

    //region Lifecycle & methods
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureBottomAppBar()
        setObservers()
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
    //endregion

    fun navigate(@IdRes actionId: Int, args: Array<Pair<String, Any?>>) {
        navController.navigate(actionId, bundleOf(*args))
    }

    fun toggleLoading(visible: Boolean) {
        loadingLayout.visible = visible
    }
}
