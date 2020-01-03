package com.example.vacunas.ui.main.view

import android.os.Bundle
import android.widget.FrameLayout
import androidx.annotation.IdRes
import androidx.appcompat.widget.ActionMenuView
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseActivity
import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.bindView
import com.example.vacunas.base.ui.visible
import com.example.vacunas.ui.main.viewmodel.MainViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

    private val loadingLayout: FrameLayout by bindView(R.id.main_loading)
    private val bottomAppBar: BottomAppBar by bindView(R.id.main_bottomAppBar)

    private val navController: NavController by lazy { findNavController(R.id.main_nav_host_fragment) }

    //region Lifecycle & methods
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureBottomAppBar()
        setObservers()
    }

    private fun configureBottomAppBar() {
        if (bottomAppBar.childCount > 0) {
            val actionMenuView = bottomAppBar.getChildAt(0) as ActionMenuView
            actionMenuView.layoutParams.width = android.widget.ActionMenuView.LayoutParams.MATCH_PARENT
        }

        bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_stop_antivaccine -> {
                    viewModel.onClickStopAntiVaccine()
                    true
                }
                R.id.menu_vaccine_history -> {
                    true
                }
                R.id.menu_vaccine_info -> {
                    true
                }
                R.id.menu_vaccine_calendar -> {
                    true
                }
                else -> false
            }
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
