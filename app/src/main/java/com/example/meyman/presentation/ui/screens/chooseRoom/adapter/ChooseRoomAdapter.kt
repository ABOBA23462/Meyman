package com.example.meyman.presentation.ui.screens.chooseRoom.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.meyman.databinding.ItemChooseRoomsBinding
import com.example.meyman.presentation.models.ResultRoomUI

class ChooseRoomAdapter : Adapter<ChooseRoomAdapter.ChooseRoomViewHolder>() {

    private val data = arrayListOf<ResultRoomUI>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<ResultRoomUI>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseRoomViewHolder {
        return ChooseRoomViewHolder(
            ItemChooseRoomsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ChooseRoomViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ChooseRoomViewHolder(val binding: ItemChooseRoomsBinding) :
        ViewHolder(binding.root) {
        fun bind(result: ResultRoomUI) {
            with(binding){
                tvPrice.text = result.price_per_night
                tvGuests.text = result.num_rooms.toString()
                tvSquare.text = result.room_area.toString()
//                tvHotelAmenities.text = result.bedType
                tvTitle.text = result.room_amenities.toString()
            }
        }

    }

}