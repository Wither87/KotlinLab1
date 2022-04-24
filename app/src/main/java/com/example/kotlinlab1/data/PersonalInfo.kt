package com.example.kotlinlab1.data

import com.google.gson.annotations.SerializedName

data class PersonalInfo(
    @SerializedName("personalaccount")
    val personalAccount: Int,
    @SerializedName("money")
    val money: Float,
    @SerializedName("topay")
    val toPay: Float
)