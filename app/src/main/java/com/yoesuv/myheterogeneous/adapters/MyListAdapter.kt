package com.yoesuv.myheterogeneous.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yoesuv.myheterogeneous.R
import com.yoesuv.myheterogeneous.databinding.ItemImageBinding
import com.yoesuv.myheterogeneous.databinding.ItemTextBinding
import com.yoesuv.myheterogeneous.models.ImageModel
import com.yoesuv.myheterogeneous.models.TextModel
import com.yoesuv.myheterogeneous.viewmodels.ItemTextViewModel

class MyListAdapter: ListAdapter<Any, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        const val ITEM_IMAGE = 0
        const val ITEM_TEXT = 1
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Any>() {
            override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
                if (oldItem is ImageModel && newItem is ImageModel) {
                    return oldItem.caption == newItem.caption
                } else if (oldItem is TextModel && newItem is TextModel) {
                    return oldItem.fullName == newItem.fullName
                } else {
                    return true
                }
            }

            override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is ImageModel) {
            ITEM_IMAGE
        } else {
            ITEM_TEXT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_IMAGE) {
            val binding: ItemImageBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_image, parent, false)
            return ItemImageViewHolder(binding)
        } else {
            val binding: ItemTextBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_text, parent, false)
            return ItemTextViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemImageViewHolder) {
            val imageModel = getItem(holder.adapterPosition) as ImageModel
            holder.bindData(imageModel)
        } else if (holder is ItemTextViewHolder) {
            val textModel = getItem(holder.adapterPosition) as TextModel
            holder.bindData(textModel)
        }
    }

    class ItemImageViewHolder(binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(imageModel: ImageModel) {

        }
    }

    class ItemTextViewHolder(private val binding: ItemTextBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(textModel: TextModel) {
            binding.itemText = ItemTextViewModel(textModel)
            binding.executePendingBindings()
        }
    }


}