package com.example.vacunas.base.utils

import androidx.lifecycle.MutableLiveData

/**
 * Set the initial value of a MutableLiveData object
 */
fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

fun Boolean.toInt() = if (this) 1 else 0