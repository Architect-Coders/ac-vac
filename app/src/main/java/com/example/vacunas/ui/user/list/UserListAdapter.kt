package com.example.vacunas.ui.user.list

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseListAdapter
import com.example.vacunas.data.model.User
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.*

class UserListAdapter<T : UserListAdapter.Listener>(listener: T) :
    BaseListAdapter<User, UserViewHolder, T>(
        listener,
        UserItemDiffCallback()
    ) {

    interface Listener : BaseListAdapter.Listener<UserViewHolder>

    override fun getLayoutId(viewType: Int): Int = R.layout.item_user

    override fun createViewHolder(view: View): UserViewHolder =
        UserViewHolder(view.rootView)
}

class UserItemDiffCallback : DiffUtil.ItemCallback<User>() { //TODO: Revisar
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem.userId == newItem.userId
}

class UserViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun setName(value: String) {
        userNameText.text = value
    }

    fun setBirthdate(value: String) {
        userBirthDateText.text = value
    }

    fun setBloodType(value: String) {
        userBloodTypeValue.text = value
    }
}