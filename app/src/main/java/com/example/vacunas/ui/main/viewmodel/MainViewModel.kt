package com.example.vacunas.ui.main.viewmodel

import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.BaseViewModel
import com.example.vacunas.data.factories.MenuItemFactory
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
                    actionId = Constants.NavActions.SPLASH_TO_USERLIST,
                    args = arrayOf("test1" to 1, "test2" to 2, "b" to null)   // TODO: QUITAR
                )
            }
        }
    }

    fun onClickFloatingActionButton() {

    }

    //region Override OnMenuItemSelected
    override fun onMenuItemSelected(menuItemType: MenuItemFactory.MenuItemType) {

    }
    //endregion
}
