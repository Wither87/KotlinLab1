package com.example.kotlinlab1.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlab1.MainApp
import com.example.kotlinlab1.presentation.viewmodels.MainViewModel
import com.example.kotlinlab1.R
import com.example.kotlinlab1.ViewModelFactory
import com.example.kotlinlab1.presentation.ui.TariffAdapter
import com.example.kotlinlab1.presentation.ui.UserInfoAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val tariffAdapter = TariffAdapter()
    private val userInfoAdapter = UserInfoAdapter()

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as MainApp).appComponent.inject(this)
        viewModel = viewModelFactory.create(MainViewModel::class.java)

        displayPersonalInfo()
        displayTariffs()
        displayUserInfo()
    }

    private fun displayTariffs() {
        viewModel.tariffLivedata.observe(this, Observer{
            val tariffs = it
            tariffAdapter.submitList(tariffs)
        })
        viewModel.loadTariffs()

        val tariffRecyclerView = findViewById<RecyclerView>(R.id.tariff_items)
        tariffRecyclerView.adapter = tariffAdapter
        val tariffDividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        tariffDividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.tariff_decoration))
        tariffRecyclerView.addItemDecoration(tariffDividerItemDecoration)
    }

    private fun displayUserInfo() {
        viewModel.userInfoLivedata.observe(this, Observer{
            val userInfo = it
            userInfoAdapter.submitList(userInfo)
        })
        viewModel.loadUserInfo()

        val userInfoRecyclerView = findViewById<RecyclerView>(R.id.user_info)
        userInfoRecyclerView.adapter = userInfoAdapter

        val userDividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        userDividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.tariff_decoration))
        userInfoRecyclerView.addItemDecoration(userDividerItemDecoration)
    }

    private fun displayPersonalInfo() {
        viewModel.personalInfoLivedata.observe(this, Observer {
            val personalInfo = it
            val personalAccount = findViewById<TextView>(R.id.personal_account)
            personalAccount.text = getString(R.string.personal_account, personalInfo?.personalAccount)

            val toPay = findViewById<TextView>(R.id.to_pay)
            val toPayValue = String.format("%.2f",personalInfo?.toPay)
            toPay.text = getString(R.string.to_pay_october, toPayValue)

            val money = findViewById<TextView>(R.id.money)
            val userMoney = String.format("%.2f", personalInfo?.money)
            money.text = getString(R.string.user_money, userMoney)
        })
        viewModel.loadPersonalInfo()
    }
}