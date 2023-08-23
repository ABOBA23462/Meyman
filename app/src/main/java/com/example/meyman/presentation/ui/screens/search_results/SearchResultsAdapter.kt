package com.example.meyman.presentation.ui.screens.search_results

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.meyman.databinding.ItemSearchResultBinding
import com.example.meyman.presentation.models.ResultUI

class SearchResultsAdapter : ListAdapter<ResultUI, SearchResultsAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(dataItem: ResultUI) {
          binding.tvHotel.text = dataItem.housingName
            binding.tvLocation.text = dataItem.description
            println(binding.tvHotel)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResultUI>() {
            override fun areItemsTheSame(oldItem: ResultUI, newItem: ResultUI): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: ResultUI, newItem: ResultUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}