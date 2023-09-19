package com.example.meyman.presentation.ui.screens.booking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.meyman.databinding.ItemBookingBinding
import com.example.meyman.presentation.models.ResultsBookingUI
import com.example.meyman.presentation.models.reservation.ReservationResultUI

class ReservationAdapter : ListAdapter<ReservationResultUI, ReservationAdapter.BookingViewHolder>(diffUtil) {

    inner class BookingViewHolder(private val binding: ItemBookingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(dataItem: ReservationResultUI) {
            binding.tvTitle.text = dataItem.room_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        return BookingViewHolder(
            ItemBookingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ReservationResultUI>() {
            override fun areItemsTheSame(
                oldItem: ReservationResultUI,
                newItem: ReservationResultUI
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ReservationResultUI,
                newItem: ReservationResultUI
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}