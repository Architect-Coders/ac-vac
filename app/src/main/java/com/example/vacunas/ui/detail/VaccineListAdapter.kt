package com.example.vacunas.ui.detail

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseListAdapter
import com.example.vacunas.data.source.remote.model.VaccineResponse
import kotlinx.android.extensions.LayoutContainer

class VaccineListAdapter<T : VaccineListAdapter.Listener>(listener: T) :
    BaseListAdapter<VaccineResponse, VaccineViewHolder, T>(
        listener,
        VaccineItemDiffCallback()
    ) {

    interface Listener : BaseListAdapter.Listener<VaccineViewHolder>

    override fun getLayoutId(viewType: Int): Int = R.layout.item_vaccine

    override fun createViewHolder(view: View): VaccineViewHolder =
        VaccineViewHolder(view.rootView)
}

class VaccineItemDiffCallback : DiffUtil.ItemCallback<VaccineResponse>() { //TODO: Revisar
    override fun areItemsTheSame(oldItem: VaccineResponse, newItem: VaccineResponse): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: VaccineResponse, newItem: VaccineResponse): Boolean =
        oldItem == newItem
}

class VaccineViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun setName(value: String) {
//        userNameText.text = value
    }
}