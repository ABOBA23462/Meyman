package com.example.meyman.presentation.ui.screens.search_results

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.meyman.databinding.ItemSearchResultBinding
import com.example.meyman.presentation.models.HotelsResult

class SearchResultsAdapter(private val onClick: (HotelsResult) -> Unit) : ListAdapter<HotelsResult, SearchResultsAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(dataItem: HotelsResult) {
            binding.tvHotel.text = dataItem.housing_name
            binding.tvLocation.text = dataItem.address
            binding.ivSearchResult.load("http://meyman.tw1.ru" + dataItem.housing_image)
            binding.tvRating.text = dataItem.stars.toString()
            println(binding.tvHotel)

            itemView.setOnClickListener {
                onClick(dataItem)
            }
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
        val diffUtil = object : DiffUtil.ItemCallback<HotelsResult>() {
            override fun areItemsTheSame(oldItem: HotelsResult, newItem: HotelsResult): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HotelsResult, newItem: HotelsResult): Boolean {
                return oldItem == newItem
            }
        }
    }
}