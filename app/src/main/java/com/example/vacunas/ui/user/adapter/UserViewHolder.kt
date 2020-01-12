package com.example.vacunas.ui.user.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.*

class UserViewHolder(
    override val containerView: View,
    private val listener: UserListAdapter.Listener
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        userDetailIcon.setOnClickListener { listener.onUserItemClick(adapterPosition) }
    }

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