package com.example.meyman.presentation.ui.screens.chooseRoom.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.meyman.databinding.ItemChooseRoomsBinding
import com.example.meyman.domain.utils.models.ChooseRoomModel

class ChooseRoomAdapter : Adapter<ChooseRoomAdapter.ChooseRoomViewHolder>() {

    private val data = arrayListOf<ChooseRoomModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<ChooseRoomModel>) {
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
        fun bind(chooseRoomModel: ChooseRoomModel) {
            with(binding){
                tvPrice.text = chooseRoomModel.price_per_night
                tvGuests.text = chooseRoomModel.num_rooms.toString()
                tvSquare.text = chooseRoomModel.room_area.toString()
                tvHotelAmenities.text = chooseRoomModel.bed_type
                tvTitle.text = chooseRoomModel.room_amenities.toString()
            }
        }

    }

}