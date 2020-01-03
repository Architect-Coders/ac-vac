package com.example.vacunas.base.ui

sealed class BaseViewCommand {
    class Navigate(val actionId: Int = -1, val args: Array<Pair<String, Any?>> = emptyArray()) :
        BaseViewCommand()

    class ConfigureToolbar : BaseViewCommand()
    class ShowToast(val msg: String, val duration: Int = 2000) : BaseViewCommand()
}
