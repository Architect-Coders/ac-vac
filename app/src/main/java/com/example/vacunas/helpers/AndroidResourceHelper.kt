package com.example.vacunas.helpers

import android.content.Context
import androidx.annotation.StringRes
import androidx.core.os.ConfigurationCompat
import java.util.*

class AndroidResourceHelper(private val context: Context) {
    fun getStringRes(@StringRes string: Int, vararg params: Any?): String =
        context.getString(string, *params)

    fun getLocale(): Locale = ConfigurationCompat.getLocales(context.resources.configuration)[0]
}
