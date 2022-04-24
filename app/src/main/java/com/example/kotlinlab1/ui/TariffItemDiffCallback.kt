package com.example.kotlinlab1.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.kotlinlab1.data.Tariff

class TariffItemDiffCallback : DiffUtil.ItemCallback<Tariff>() {
    override fun areItemsTheSame(oldItem: Tariff, newItem: Tariff): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Tariff, newItem: Tariff): Boolean = oldItem == newItem

}
