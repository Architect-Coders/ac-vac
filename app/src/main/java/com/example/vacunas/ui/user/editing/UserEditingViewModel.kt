package com.example.vacunas.ui.user.editing

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.BaseViewModel

class UserEditingViewModel : BaseViewModel() {

    val visibleBottomAppBar = MutableLiveData<Boolean>()
    val visibleFabButton = MutableLiveData<Boolean>()
    val birthDate = MutableLiveData<String>()


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        hideBottomViews()
    }

    private fun hideBottomViews() {
        visibleBottomAppBar.value = false
        visibleFabButton.value = false
    }

    fun onAfterNameTextChanged(text: CharSequence) {

    }

    fun onBirthdateClicked() {
        _viewCommand.value = BaseViewCommand.OpenDatePickerDialog
    }

    fun onBirthdateSelected(time: Long) {
        birthDate.value = time.toString()
    }

    fun onBloodTypeSelected(position: Int) {
        println(">>> BLOOD POSITION SELECTED = $position")
    }

    fun onRegionSelected(position: Int) {
        println(">>> REGION POSITION SELECTED = $position")
    }

    fun onCancelClicked() {
        _viewCommand.value = BaseViewCommand.BackNavigate
    }

    fun onOkClicked() {

    }
}