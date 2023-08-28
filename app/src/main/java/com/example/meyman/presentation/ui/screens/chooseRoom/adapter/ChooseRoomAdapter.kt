package com.example.meyman.presentation.ui.screens.chooseRoom.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.meyman.databinding.ItemChooseRoomsBinding
import com.example.meyman.domain.utils.models.ChooseRoomModel
import com.example.meyman.domain.utils.models.ResultDomain

class ChooseRoomAdapter : Adapter<ChooseRoomAdapter.ChooseRoomViewHolder>() {

    private val data = arrayListOf<ResultDomain>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<ResultDomain>) {
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
        fun bind(result: ResultDomain) {
            with(binding){
                tvPrice.text = result.price_per_night
                tvGuests.text = result.num_rooms.toString()
                tvSquare.text = result.room_area.toString()
                tvHotelAmenities.text = result.bed_type
                tvTitle.text = result.room_amenities.toString()
            }
        }

    }

}