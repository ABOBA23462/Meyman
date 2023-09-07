package com.example.meyman.presentation.ui.screens.hotel_page.rooms

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.meyman.core.base.BaseDiffUtil
import com.example.meyman.databinding.ItemPhotoRoomsBinding
import com.example.meyman.presentation.models.RoomImageUI

class PhotoAdapter() : ListAdapter<RoomImageUI, PhotoAdapter.PhotoViewHolder>(BaseDiffUtil()) {
    inner class PhotoViewHolder(val binding: ItemPhotoRoomsBinding) : ViewHolder(binding.root) {
        fun onBind(model: RoomImageUI) {
            Log.e("ololo", "onBind: " + {model})
            binding.ivPhoto.setImage(model.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(ItemPhotoRoomsBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    fun ImageView.setImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .into(this)
    }
}