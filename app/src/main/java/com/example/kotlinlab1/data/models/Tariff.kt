package com.example.kotlinlab1.data.models

import com.google.gson.annotations.SerializedName

data class Tariff(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("cost")
    val cost: Float
)