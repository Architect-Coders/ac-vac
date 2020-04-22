package com.example.vacunas.ui.detail

import androidx.lifecycle.*
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.BaseViewModel
import com.example.domain.SpainRegion
import com.example.domain.User
import com.example.data.UserRepository
import com.example.data.utils.Response
import kotlinx.coroutines.launch
import org.koin.core.inject
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random


class DetailViewModel(private val userId: Int) : BaseViewModel(), VaccineListAdapter.Listener {

    private val userRepository: UserRepository by inject()
    val user = MutableLiveData<User>()

    val isLoading = MutableLiveData<Boolean>()
    val visibleBottomAppBar = MutableLiveData<Boolean>()
    val visibleFabButton = MutableLiveData<Boolean>()
    val userView: LiveData<UserUIModel> = Transformations.map(user) {
        UserUIModel(
            it.name,
            SimpleDateFormat(
                androidResourceHelper.getStringRes(R.string.user_detail_birthdate_format),
                androidResourceHelper.getLocale()
            ).format(Date(it.birthDate)),
            androidResourceHelper
                .getStringArrayRes(R.array.user_bloodtype_array)[it.bloodType.ordinal],
            androidResourceHelper
                .getStringArrayRes(R.array.user_region_array)[it.region.ordinal]
        )
    }


    inner class UserUIModel(
        val name: String,
        val birthDate: String,
        val bloodType: String,
        val region: String
    )


    init {
        getUserFromRepository(userId)
//        getVaccineListFromRepository(user.value!!.region)
    }

    private fun getUserFromRepository(userId: Int) {
        viewModelScope.launch {
            when (val response = userRepository.findUserById(userId)) {
                is Response.Success -> {
                    user.value = response.data
                    isLoading.value = false
                }
                is Response.Error -> {
                    _viewCommand.value = BaseViewCommand
                        .ShowToast(
                            androidResourceHelper.getStringRes(
                                R.string.user_detail_error_db,
                                response.message ?: "unknown"
                            )
                        )
                    isLoading.value = false
                }
            }
        }
    }


    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        isLoading.value = true
        hideBottomViews()
    }

    private fun hideBottomViews() {
        visibleBottomAppBar.value = false
        visibleFabButton.value = false
    }

    private fun getVaccineListFromRepository(region: SpainRegion) {

    }

    //region Override VaccineListAdapter.Listener methods
    override fun onBindViewHolder(holder: VaccineViewHolder, position: Int) {
        holder.setName(Random.nextInt(100).toString())
    }
    //endregion
}
