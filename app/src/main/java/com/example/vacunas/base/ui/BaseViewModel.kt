package com.example.vacunas.base.ui

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.example.vacunas.base.utils.SingleLiveEvent
import com.example.vacunas.helpers.AndroidResourceHelper
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseViewModel : ViewModel(), LifecycleObserver, KoinComponent {

    protected val androidResourceHelper: AndroidResourceHelper by inject()

    @Suppress("PropertyName")
    protected val _viewCommand: SingleLiveEvent<BaseViewCommand> = SingleLiveEvent()

    fun getViewCommand() = _viewCommand
}
