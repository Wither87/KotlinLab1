package com.example.kotlinlab1

import androidx.recyclerview.widget.DiffUtil

class UserItemDiffCallback : DiffUtil.ItemCallback<UserInfo>() {
    override fun areItemsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean = oldItem == newItem

}
