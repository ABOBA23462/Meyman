package com.example.meyman.presentation.ui.screens.room_page.tablayout.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.meyman.databinding.ItemReviewBinding
import com.example.meyman.presentation.models.ReviewItemUI

class ReviewAdapter: ListAdapter<ReviewItemUI, ReviewAdapter.ViewHolder>(
    diffUtil
) {

    inner class ViewHolder(private val binding: ItemReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

//        init {
//            itemView.setOnClickListener {
//                getItem(absoluteAdapterPosition)?.let { it1 -> onItemClick(it1) }
//            }
//        }

        fun onBind(reviewItem: ReviewItemUI) {
            binding.tvDescription.text = reviewItem.comment.toString()
            println(binding.tvDescription)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ReviewItemUI>() {
            override fun areItemsTheSame(oldItem: ReviewItemUI, newItem: ReviewItemUI): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ReviewItemUI, newItem: ReviewItemUI): Boolean {
                return oldItem == newItem
            }
        }
    }
    }