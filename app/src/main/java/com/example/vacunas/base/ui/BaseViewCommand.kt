package com.example.vacunas.base.ui

import androidx.annotation.IntRange
import java.util.*

sealed class BaseViewCommand {
    class Navigate(val actionId: Int = -1, val args: Array<Pair<String, Any?>> = emptyArray()) :
        BaseViewCommand()

    object BackNavigate : BaseViewCommand()
    object OpenDatePickerDialog : BaseViewCommand()
    class ShowToast(val msg: String, val largeDuration: Boolean = true) : BaseViewCommand()
}
