package com.example.kotlinlab1.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.kotlinlab1.data.UserInfo

class UserItemDiffCallback : DiffUtil.ItemCallback<UserInfo>() {
    override fun areItemsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean = oldItem == newItem

}
