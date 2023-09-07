package com.example.meyman.presentation.ui.screens.hotel_page.rooms

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.bumptech.glide.Glide
import com.example.meyman.databinding.ItemRoomBinding
import com.example.meyman.presentation.models.ResultRoomUI

class RoomsAdapter( val onItemClick: (id: Int) -> Unit,
                    val onButtonClick: (id: Int) -> Unit,) : ListAdapter<ResultRoomUI, RoomsAdapter.ViewHolder>(
    diffUtil
) {

    private lateinit var adapter: PhotoAdapter

    fun ImageView.setImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .into(this)
    }

    inner class ViewHolder(private val binding: ItemRoomBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(result: ResultRoomUI) = with(binding) {
            tvPrice.text = result.price_per_night
            tvGuests.text = result.num_rooms.toString()
            tvSquare.text = "${result.room_area} m²"
            tvHotelAmenities.text = "Двухместная кровать  и диван "
            adapter = PhotoAdapter()
            rcPhotos.adapter = adapter
            val snapHelper: SnapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(rcPhotos)
            result.room_images.let { adapter.submitList(it) }

        }
        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { it1 -> onItemClick(it1.id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
