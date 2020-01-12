package com.example.vacunas.ui.user.adapter

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseListAdapter
import com.example.vacunas.data.model.User

class UserListAdapter<T : UserListAdapter.Listener>(private val listener: T) :
    BaseListAdapter<User, UserViewHolder, T>(
        listener,
        UserItemDiffCallback()
    ) {

    override fun getLayoutId(viewType: Int): Int = R.layout.item_user

    override fun createViewHolder(view: View): UserViewHolder =
        UserViewHolder(view.rootView, listener)

    interface Listener : BaseListAdapter.Listener<UserViewHolder> {
        fun onUserItemClick(position: Int)
    }
}

class UserItemDiffCallback : DiffUtil.ItemCallback<User>() { //TODO: Revisar
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
        oldItem.userId == newItem.userId
}