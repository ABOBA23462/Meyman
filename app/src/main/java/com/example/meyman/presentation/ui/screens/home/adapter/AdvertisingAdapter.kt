package com.example.meyman.presentation.ui.screens.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.meyman.databinding.ItemRecomedationBinding
import com.example.meyman.presentation.models.home.AdvertisingResultUI

class AdvertisingAdapter :
    ListAdapter<AdvertisingResultUI, AdvertisingAdapter.AdvertisingViewHolder>(diffUtil) {

    inner class AdvertisingViewHolder(val binding: ItemRecomedationBinding) :
        ViewHolder(binding.root) {

        fun onBind(item: AdvertisingResultUI?) {
            binding.tvHotelName.text = item?.housingName
        }
    }
    fun ImageView.setImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .into(this)
    }

    fun convertToHttpsUrl(httpUrl: String): String {
        // Проверяем, начинается ли URL с "http://" (без "s")
        if (httpUrl.startsWith("http://")) {
            // Заменяем "http://" на "https://"
            return "https://" + httpUrl.substring(7)
        }

        // Если URL уже начинается с "https://", то оставляем его без изменений
        if (httpUrl.startsWith("https://")) {
            return httpUrl
        }

        // Если URL не начинается ни с "http://", ни с "https://", вернем его без изменений
        return httpUrl
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertisingViewHolder {
        return AdvertisingViewHolder(
            ItemRecomedationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AdvertisingViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<AdvertisingResultUI>() {
            override fun areItemsTheSame(oldItem: AdvertisingResultUI, newItem: AdvertisingResultUI): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: AdvertisingResultUI, newItem: AdvertisingResultUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}