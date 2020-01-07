package com.example.vacunas.ui.user

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.vacunas.base.ui.BaseViewModel
import com.example.vacunas.data.model.User
import kotlin.random.Random

class UserListViewModel : BaseViewModel(), UserListAdapter.Listener {

    val users = MutableLiveData<List<User>>()

    init {
        users.value = listOf(User("1"), User("2"), User("3"))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        // In this method, the user list is updated when an orientation change occurs
        users.value = listOf(
            User(Random.nextInt(100).toString()),
            User(Random.nextInt(100).toString()),
            User(Random.nextInt(100).toString())
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setName(users.value!![position].name)
    }
}
