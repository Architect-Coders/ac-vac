package com.example.vacunas.ui.user.list

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.vacunas.base.ui.BaseViewModel
import com.example.vacunas.data.model.User
import com.example.vacunas.ui.user.list.UserListAdapter
import com.example.vacunas.ui.user.list.UserViewHolder
import kotlin.random.Random

class UserListViewModel : BaseViewModel(), UserListAdapter.Listener {

    val visibleBottomAppBar = MutableLiveData<Boolean>()
    val visibleFabButton = MutableLiveData<Boolean>()
    val users = MutableLiveData<List<User>>()

    init {
        users.value = listOf(
            User(name = Random.nextInt(100).toString()),
            User(name = Random.nextInt(100).toString()),
            User(name = Random.nextInt(100).toString())
        )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        // In this method, the user list is updated when an orientation change occurs
//        users.value = listOf(
//            User(name = Random.nextInt(100).toString()),
//            User(name = Random.nextInt(100).toString()),
//            User(name = Random.nextInt(100).toString())
//        )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        showBottomViews()
    }

    private fun showBottomViews() {
        visibleBottomAppBar.value = true
        visibleFabButton.value = true
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setName(users.value!![position].name)
    }
}
