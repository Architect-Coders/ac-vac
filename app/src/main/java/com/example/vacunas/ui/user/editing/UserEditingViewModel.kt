package com.example.vacunas.ui.user.editing

import androidx.lifecycle.*
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.BaseViewModel
import com.example.domain.BloodType
import com.example.domain.SpainRegion
import com.example.domain.User
import com.example.data.UserRepository
import com.example.data.utils.Response
import kotlinx.coroutines.launch
import org.koin.core.inject
import java.text.SimpleDateFormat
import java.util.*


class UserEditingViewModel : BaseViewModel() {

    private val userRepository: UserRepository by inject()

    companion object {
        const val DATE_FORMAT = "dd/MM/yyyy"
    }

    private lateinit var userName: String
    private var userBirthDate = MutableLiveData<Long>()
    private var userBloodType: BloodType = BloodType.UNKNOWN
    private var userRegion: SpainRegion = SpainRegion.UNKNOWN

    val visibleBottomAppBar = MutableLiveData<Boolean>()
    val visibleFabButton = MutableLiveData<Boolean>()
    val birthDate: LiveData<String> = Transformations.map(userBirthDate) {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, androidResourceHelper.getLocale())
        dateFormat.format(Date(it))
    }


    //region Lifecycle methods
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        hideBottomViews()
    }

    private fun hideBottomViews() {
        visibleBottomAppBar.value = false
        visibleFabButton.value = false
    }
    //endregion

    fun onAfterNameTextChanged(text: CharSequence) {
        userName = text.toString()
    }

    fun onBirthdateClicked() {
        _viewCommand.value = BaseViewCommand.OpenDatePickerDialog
    }

    fun onBirthdateSelected(time: Long) {
        userBirthDate.value = time
    }

    fun onBloodTypeSelected(position: Int) {
        userBloodType = BloodType.values()[position]
    }

    fun onRegionSelected(position: Int) {
        userRegion = SpainRegion.values()[position]
    }

    fun onCancelClicked() {
        _viewCommand.value = BaseViewCommand.BackNavigate
    }

    fun onOkClicked() {
        when {
            !::userName.isInitialized || userName.isBlank() -> {
                _viewCommand.value = BaseViewCommand
                    .ShowToast(
                        androidResourceHelper.getStringRes(R.string.user_editing_error_username_empty)
                    )
            }
            userBirthDate.value == null -> {
                _viewCommand.value = BaseViewCommand
                    .ShowToast(
                        androidResourceHelper.getStringRes(R.string.user_editing_error_birthdate_empty)
                    )
            }
            else -> {
                saveUser(User(userName, userBirthDate.value!!, userBloodType, userRegion))
            }
        }
    }

    private fun saveUser(user: User) {
        viewModelScope.launch {
            when (val response = userRepository.saveUser(user)) {
                is Response.Success -> {
                    println(">>> ID insertado: ${response.data}")
                    _viewCommand.value = BaseViewCommand.BackNavigate
                }
                is Response.Error -> {
                    _viewCommand.value = BaseViewCommand
                        .ShowToast(
                            androidResourceHelper.getStringRes(
                                R.string.user_editing_error_insert_db,
                                response.message ?: "unknown"
                            )
                        )
                }
            }
        }
    }
}