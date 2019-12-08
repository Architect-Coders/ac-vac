package com.example.vacunas.helpers

import android.content.Context
import androidx.annotation.StringRes

class AndroidResourceHelper(private val context: Context) {
    fun getStringRes(@StringRes string: Int, vararg params: Any = emptyArray()): String =
        context.getString(string, *params)
}
