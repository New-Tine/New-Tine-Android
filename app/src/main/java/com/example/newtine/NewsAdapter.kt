package com.example.newtine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newtine.databinding.ItemNewsBinding

class NewsAdapter: ListAdapter<NewsModel, NewsAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: NewsModel){
            binding.newsGroupTitleTextView.text = item.title

            Glide.with(binding.newsGroupThumbnailImageView)
                .load(item.imageUrl)
                .into(binding.newsGroupThumbnailImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<NewsModel>() {
            override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
                return oldItem == newItem
            }

        }
    }


}