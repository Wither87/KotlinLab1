package com.example.kotlinlab1

import androidx.recyclerview.widget.DiffUtil

class TariffItemDiffCallback : DiffUtil.ItemCallback<Tariff>() {
    override fun areItemsTheSame(oldItem: Tariff, newItem: Tariff): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Tariff, newItem: Tariff): Boolean = oldItem == newItem

}
