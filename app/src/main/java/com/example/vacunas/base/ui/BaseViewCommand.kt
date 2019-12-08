package com.example.vacunas.base.ui

import android.widget.Toast

sealed class BaseViewCommand {
    class GoTo(val to: String) : BaseViewCommand()
    class Navigate(
        val from: String,
        val to: String,
        val bundle: Array<Pair<String, Any>> = emptyArray()
    ) : BaseViewCommand()

    class Action(val actionId: Int = -1, val params: Map<String, Any> = emptyMap()) :
        BaseViewCommand()

    class ConfigureToolbar : BaseViewCommand()
    class ShowToast(val msg: String, val duration: Int = Toast.LENGTH_SHORT) : BaseViewCommand()
}
