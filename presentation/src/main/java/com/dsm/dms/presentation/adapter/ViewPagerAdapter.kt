package com.dsm.dms.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem

class ViewPagerAdapter : RecyclerView.Adapter<BindingViewHolder>() {

    private val items = mutableListOf<ViewPagerItem>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).layoutId
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder,
        position: Int
    ) {
        getItem(position).bind(holder.binding)
        holder.binding.executePendingBindings()
    }

    fun updateData(newItems: List<ViewPagerItem>) {
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): ViewPagerItem {
        return items[position]
    }
}

class BindingViewHolder(
    val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root)
