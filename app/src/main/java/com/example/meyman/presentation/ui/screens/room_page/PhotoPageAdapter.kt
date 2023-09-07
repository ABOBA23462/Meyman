package com.example.meyman.presentation.ui.screens.room_page

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meyman.core.base.BaseDiffUtil
import com.example.meyman.databinding.ItemPhotoRoomsBinding
import com.example.meyman.presentation.models.rooms.RoomImagesItemUI


class PhotoPageAdapter() :
    ListAdapter<RoomImagesItemUI, PhotoPageAdapter.ViewHolder>(BaseDiffUtil()) {
    inner class ViewHolder(val binding: ItemPhotoRoomsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: RoomImagesItemUI) {
            Log.e("ololo", "onBind: " + { model })
            binding.ivPhoto.setImage(model.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemPhotoRoomsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    fun ImageView.setImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .into(this)
    }
}