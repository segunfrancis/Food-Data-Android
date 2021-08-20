package com.segunfrancis.fooddataandroid.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.segunfrancis.fooddataandroid.R
import com.segunfrancis.fooddataandroid.databinding.ItemFoodHomeBinding
import com.segunfrancis.fooddataandroid.model.BaseResponseItemApp

class HomeRecyclerAdapter(private val onItemClick: (BaseResponseItemApp) -> Unit) : ListAdapter<BaseResponseItemApp, HomeRecyclerAdapter.HomeViewHolder>(HomeDiffUtil()) {

    inner class HomeViewHolder(private val binding: ItemFoodHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemApp: BaseResponseItemApp) = with(binding) {
            descriptionText.text = itemApp.description
            pubDate.text = itemApp.publicationDate
            root.setOnClickListener { onItemClick(itemApp) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_home, parent, false)
        return HomeViewHolder(ItemFoodHomeBinding.bind(view))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeDiffUtil : DiffUtil.ItemCallback<BaseResponseItemApp>() {
        override fun areItemsTheSame(
            oldItem: BaseResponseItemApp,
            newItem: BaseResponseItemApp
        ): Boolean {
            return oldItem.fdcId == newItem.fdcId
        }

        override fun areContentsTheSame(
            oldItem: BaseResponseItemApp,
            newItem: BaseResponseItemApp
        ): Boolean {
            return oldItem == newItem
        }
    }
}
