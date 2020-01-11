package com.example.vacunas.ui.user.list

import androidx.lifecycle.*
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseViewCommand
import com.example.vacunas.base.ui.BaseViewModel
import com.example.vacunas.data.model.User
import com.example.vacunas.data.repository.RepositoryFactory
import com.example.vacunas.data.repository.utils.Response
import kotlinx.coroutines.launch
import org.koin.core.inject

class UserListViewModel : BaseViewModel(), UserListAdapter.Listener {

    private val repository: RepositoryFactory by inject()
    val repositoryUserList = MutableLiveData<List<User>>()

    val isLoading = MutableLiveData<Boolean>()
    val visibleBottomAppBar = MutableLiveData<Boolean>()
    val visibleFabButton = MutableLiveData<Boolean>()
    val viewUserListEmptyTextVisible = MutableLiveData<Boolean>()
    val viewUserListVisible: LiveData<Boolean> = Transformations.map(viewUserListEmptyTextVisible) {
        viewUserListEmptyTextVisible.value?.not()
    }
    val viewUsersList: LiveData<List<User>> = Transformations.map(repositoryUserList) {
        repositoryUserList.value?.sortedWith(compareBy { it.region })
    }

//    init {
//        // In this method, the superhero list only is updated when the viewmodel is created
//        // The data are kept when an orientation change occurs
//        repositoryUserList = getUserListFromRepository()
//    }

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        isLoading.value = true
        showBottomViews()
        getUserListFromRepository()
    }

    private fun showBottomViews() {
        visibleBottomAppBar.value = true
        visibleFabButton.value = true
    }

    private fun getUserListFromRepository() {
        viewModelScope.launch {
            when (val response = repository.getUserList()) {
                is Response.Success -> {
                    repositoryUserList.value = response.data
                    viewUserListEmptyTextVisible.value = ((response.data?.size ?: 0) <= 0)
                    isLoading.value = false
                }
                is Response.Error -> {
                    viewUserListEmptyTextVisible.value = false
                    _viewCommand.value = BaseViewCommand
                        .ShowToast(
                            androidResourceHelper.getStringRes(
                                R.string.user_list_error_get_db,
                                response.message ?: "unknown"
                            )
                        )
                    isLoading.value = false
                }
            }
        }
    }

    //region Override UserListAdapter.Listener methods
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setName(viewUsersList.value!![position].name)
    }
    //endregion
}
