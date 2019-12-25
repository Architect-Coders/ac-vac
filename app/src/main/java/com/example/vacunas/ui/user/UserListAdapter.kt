package com.example.vacunas.ui.user

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseListAdapter
import com.example.vacunas.base.ui.bindView
import com.example.vacunas.data.model.User

class UserListAdapter<T : UserListAdapter.Listener>(listener: T) :
    BaseListAdapter<User, UserViewHolder, T>(listener, UserItemDiffCallback()) {

    interface Listener : BaseListAdapter.Listener<UserViewHolder>

    override fun getLayoutId(viewType: Int): Int = R.layout.item_user

    override fun createViewHolder(view: View): UserViewHolder = UserViewHolder(view.rootView)
}

class UserItemDiffCallback : DiffUtil.ItemCallback<User>() { //TODO: Revisar
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem
}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.rootView) {
    private val name: TextView by bindView(R.id.item_user_name)

    fun setName(value: String) {
        name.text = value
    }
}