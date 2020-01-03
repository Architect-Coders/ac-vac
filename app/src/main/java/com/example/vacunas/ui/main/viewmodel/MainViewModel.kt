package com.example.vacunas.ui.main.viewmodel

import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.BaseViewModel
import com.example.vacunas.utils.Constants
import kotlinx.coroutines.*

class MainViewModel : BaseViewModel() {
    companion object {
        const val DELAY_SPLASH = 3000L
    }

    init {
        GlobalScope.launch {
            delay(DELAY_SPLASH)
            withContext(Dispatchers.Main) {
                _viewCommand.value = BaseViewCommand.Navigate(
                    actionId = Constants.NavActions.splash_to_userList,
                    args = arrayOf("test1" to 1, "test2" to 2, "b" to null)   // TODO: QUITAR
                )
            }
        }
    }

    fun onClickStopAntiVaccine() {

    }
}
