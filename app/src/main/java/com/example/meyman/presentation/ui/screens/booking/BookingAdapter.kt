//package com.example.meyman.presentation.ui.screens.booking
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.meyman.databinding.ItemBookingBinding
//import com.example.meyman.presentation.models.ResultsBookingUI
//
//class BookingAdapter : ListAdapter<ResultsBookingUI, BookingAdapter.BookingViewHolder>(diffUtil) {
//
//    inner class BookingViewHolder(private val binding: ItemBookingBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun onBind(dataItem: ResultsBookingUI) {
//            binding.tvHotelName.text = dataItem.title
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
//        return BookingViewHolder(
//            ItemBookingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
//        getItem(position)?.let {
//            holder.onBind(it)
//        }
//    }
//
//    companion object {
//        val diffUtil = object : DiffUtil.ItemCallback<ResultsBookingUI>() {
//            override fun areItemsTheSame(
//                oldItem: ResultsBookingUI,
//                newItem: ResultsBookingUI
//            ): Boolean {
//                return oldItem.id == newItem.id
//            }
//
//            override fun areContentsTheSame(
//                oldItem: ResultsBookingUI,
//                newItem: ResultsBookingUI
//            ): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//
//}