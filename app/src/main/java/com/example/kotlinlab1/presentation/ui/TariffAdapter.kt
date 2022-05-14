package com.example.kotlinlab1.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlab1.R
import com.example.kotlinlab1.data.models.Tariff

class TariffAdapter : ListAdapter<Tariff, TariffAdapter.ViewHolder>(TariffItemDiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tariffTitle = view.findViewById<TextView>(R.id.tariff_title)
        private val tariffDescription = view.findViewById<TextView>(R.id.tariff_description)
        private val tariffCost = view.findViewById<TextView>(R.id.tariff_cost)

        fun bind(tariff: Tariff) {
            tariffTitle.text = tariff.title
            tariffDescription.text = tariff.description
            tariffCost.text = "${String.format("%.2f", tariff.cost)} ₽"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tariff_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}
