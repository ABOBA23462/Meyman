package com.example.meyman.presentation.ui.screens.search_results

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.meyman.databinding.ItemSearchResultBinding
import com.example.meyman.presentation.models.hotels.ResultsHotelItemUI

class SearchResultsAdapter(private val onClick: (ResultsHotelItemUI) -> Unit,
                           val onButtonClick: (id: Int) -> Unit) : ListAdapter<ResultsHotelItemUI, SearchResultsAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(dataItem: ResultsHotelItemUI) {
            binding.tvHotel.text = dataItem.housingName
            binding.tvLocation.text = dataItem.address
            binding.ivSearchResult.setImage("https://meyman.geeks.kg${dataItem.housingImage}")
            binding.tvRating.text = dataItem.stars.toString()
            println(binding.tvHotel)

            itemView.setOnClickListener {
                onClick(dataItem)
            }
            binding.like.setOnClickListener {
                onButtonClick.invoke(absoluteAdapterPosition)
            }
        }

        fun ImageView.setImage(uri: String) {
            Glide.with(this)
                .load(uri)
                .into(this)
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
        val diffUtil = object : DiffUtil.ItemCallback<ResultsHotelItemUI>() {
            override fun areItemsTheSame(oldItem: ResultsHotelItemUI, newItem: ResultsHotelItemUI): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultsHotelItemUI, newItem: ResultsHotelItemUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}