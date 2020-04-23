package com.example.vacunas.ui.main.viewmodel

import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.BaseViewModel
import com.example.vacunas.factories.MenuItemFactory
import com.example.vacunas.utils.Constants
import kotlinx.coroutines.*

class MainViewModel : BaseViewModel(), MenuItemFactory.OnMenuItemSelected {
    companion object {
        const val DELAY_SPLASH = 3000L
    }

    init {
        GlobalScope.launch {
            delay(DELAY_SPLASH)
            withContext(Dispatchers.Main) {
                _viewCommand.value = BaseViewCommand.Navigate(
                    actionId = Constants.NavActions.SPLASH_TO_USERLIST
                )
            }
        }
    }

    fun onClickFloatingActionButton() {
        _viewCommand.value = BaseViewCommand.Navigate(
            actionId = Constants.NavActions.USERLIST_TO_USEREDITING
        )
    }

    //region Override OnMenuItemSelected
    override fun onMenuItemSelected(menuItemType: MenuItemFactory.MenuItemType) {

    }
    //endregion
}
