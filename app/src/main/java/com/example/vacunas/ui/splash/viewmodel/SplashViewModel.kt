package com.example.vacunas.ui.splash.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.vacunas.base.ui.BaseViewModel

class SplashViewModel : BaseViewModel() {

    val visibleBottomAppBar = MutableLiveData<Boolean>()
    val visibleFabButton = MutableLiveData<Boolean>()

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        hideBottomViews()
    }

    private fun hideBottomViews() {
        visibleBottomAppBar.value = false
        visibleFabButton.value = false
    }
}
