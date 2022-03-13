package com.example.kotlinlab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class UserInfoAdapter : ListAdapter<UserInfo, UserInfoAdapter.ViewHolder>(UserItemDiffCallback()) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val userInfoText = view.findViewById<TextView>(R.id.user_info_text)
        private val userInfoIcon = view.findViewById<ImageView>(R.id.user_info_icon)

        fun bind(userInfo: UserInfo) {
            userInfoText.text = userInfo.text
            userInfoIcon.setImageResource(userInfo.iconId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_info_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}