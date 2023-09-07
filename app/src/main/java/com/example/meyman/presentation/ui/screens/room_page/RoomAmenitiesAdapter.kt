package com.example.meyman.presentation.ui.screens.room_page

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.bumptech.glide.Glide
import com.example.meyman.databinding.ItemRoomAmenitiesBinding
import com.example.meyman.databinding.ItemRoomBinding
import com.example.meyman.presentation.models.ResultRoomUI
import com.example.meyman.presentation.ui.screens.hotel_page.rooms.PhotoAdapter

class RoomAmenitiesAdapter() : ListAdapter<ResultRoomUI, RoomAmenitiesAdapter.ViewHolder>(
    diffUtil
) {

    inner class ViewHolder(private val binding: ItemRoomAmenitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(result: ResultRoomUI) = with(binding) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRoomAmenitiesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResultRoomUI>() {
            override fun areItemsTheSame(oldItem: ResultRoomUI, newItem: ResultRoomUI): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultRoomUI, newItem: ResultRoomUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}
