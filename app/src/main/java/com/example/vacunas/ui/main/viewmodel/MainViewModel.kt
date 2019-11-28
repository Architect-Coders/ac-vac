package com.example.vacunas.ui.main.viewmodel

import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.BaseViewModel
import com.example.vacunas.utils.Constants
import kotlinx.coroutines.*

class MainViewModel : BaseViewModel() {

    init {
        _viewCommand.value = BaseViewCommand.GoTo(to = Constants.Screens.SPLASH_FRAGMENT)

        GlobalScope.launch {
            delay(3000)
            withContext(Dispatchers.Main) {
                _viewCommand.value = BaseViewCommand.GoTo(
                    to = Constants.Screens.BLANK_FRAGMENT
                )
            }
        }
    }
}