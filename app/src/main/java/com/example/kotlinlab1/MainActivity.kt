package com.example.kotlinlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region Personal info

        val personalAccount = findViewById<TextView>(R.id.personal_account)
        val toPay = findViewById<TextView>(R.id.to_pay)
        val money = findViewById<TextView>(R.id.money)
        val personalInfo = PersonalInfo(
            11010010,
            100.42f,
            0.0f
        )
        personalAccount.text = "ЛС: ${personalInfo.personalAccount}"
        toPay.text = "${getString(R.string.to_pay_october)} ${String.format("%.2f", personalInfo.toPay)}${getString(R.string.ruble_symbol)}"
        money.text = "${String.format("%.2f", personalInfo.money)} ${getString(R.string.ruble_symbol)}"

        //endregion

        //region Tariff recycler fill

        val tariffRecyclerView = findViewById<RecyclerView>(R.id.tariff_items)
        val tariffAdapter = TariffAdapter()
        tariffAdapter.submitList(
            mutableListOf(
                Tariff(
                    id = 1,
                    title = "Тариф «Улыбка (Бесплатрный)»",
                    description = "Скорость до 50 Мбит/с",
                    cost = 0.0f
                ),
                Tariff(
                    id = 2,
                    title = "Тариф «Разочарование (Платный)»",
                    description = "Скорость до 100 Мбит/с",
                    cost = 300.0f
                )
            )
        )
        tariffRecyclerView.adapter = tariffAdapter
        val tariffDividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        tariffDividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.tariff_decoration))
        tariffRecyclerView.addItemDecoration(tariffDividerItemDecoration)

        //endregion

        //region User info recycler fill

        val userInfoRecyclerView = findViewById<RecyclerView>(R.id.user_info)
        val userInfoAdapter = UserInfoAdapter()
        userInfoAdapter.submitList(
            mutableListOf(
                UserInfo(
                    id = 1,
                    text = "Иванов Иван Иванович",
                    iconId = R.drawable.outline_account_circle_24
                ),
                UserInfo(
                    id = 2,
                    text = "Сахалин, ул. Пушкина. д. Какой-то там",
                    iconId = R.drawable.outline_home_24
                ),
                UserInfo(
                    id = 3,
                    text = "Доступные услуги",
                    iconId = R.drawable.outline_dashboard_24
                )
            )
        )
        userInfoRecyclerView.adapter = userInfoAdapter
        val userDividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        userDividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.tariff_decoration))
        userInfoRecyclerView.addItemDecoration(tariffDividerItemDecoration)

        //endregion
    }
}