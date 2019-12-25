package com.example.vacunas.base.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<ItemModel, ItemVH : RecyclerView.ViewHolder, L : BaseListAdapter.Listener<ItemVH>>(
    private val listener: L,
    diffType: DiffUtil.ItemCallback<ItemModel>
) : ListAdapter<ItemModel, ItemVH>(diffType) {

    //region Override RecyclerView.Adapter methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutId(viewType), parent, false)
        return createViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) =
        listener.onBindViewHolder(holder, position)

//    override fun getItemViewType(position: Int): Int = listener.getItemType(position)
    //endregion

    abstract fun getLayoutId(viewType: Int): Int

    abstract fun createViewHolder(view: View): ItemVH

    interface Listener<VH : RecyclerView.ViewHolder> {
        companion object ItemType {
            const val NORMAL = 0
            const val HEADER = 1
        }

        fun onBindViewHolder(holder: VH, position: Int)
//        fun onItemClick(position: Int) {} //FIXME
    }
}