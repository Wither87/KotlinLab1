package com.example.kotlinlab1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlab1.api.RetrofitClient
import com.example.kotlinlab1.data.PersonalInfo
import com.example.kotlinlab1.data.Tariff
import com.example.kotlinlab1.data.UserInfo
import com.example.kotlinlab1.ui.TariffAdapter
import com.example.kotlinlab1.ui.UserInfoAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    val tariffAdapter = TariffAdapter()
    val userInfoAdapter = UserInfoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region Personal info
        getPersonalInfo(11010010)
        //endregion

        //region Tariff recycler fill
        val tariffRecyclerView = findViewById<RecyclerView>(R.id.tariff_items)
        getTariffs()
        tariffRecyclerView.adapter = tariffAdapter
        val tariffDividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        tariffDividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.tariff_decoration))
        tariffRecyclerView.addItemDecoration(tariffDividerItemDecoration)
        //endregion

        //region User info recycler fill
        val userInfoRecyclerView = findViewById<RecyclerView>(R.id.user_info)
        getUserInfo()
        userInfoRecyclerView.adapter = userInfoAdapter
        val userDividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        userDividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.tariff_decoration))
        userInfoRecyclerView.addItemDecoration(tariffDividerItemDecoration)
        //endregion
    }

    private fun getTariffs() {
        val service = RetrofitClient.retrofitService.getTariffList().enqueue(
            object : Callback<List<Tariff>> {
                override fun onFailure(call: Call<List<Tariff>>, t: Throwable) {
                    //TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<List<Tariff>>,
                    response: Response<List<Tariff>>
                ) {
                    tariffAdapter.submitList(response.body())
                }
            }
        )
    }

    private fun getUserInfo() {
        val service = RetrofitClient.retrofitService.getUserInfoList().enqueue(
            object : Callback<List<UserInfo>> {
                override fun onFailure(call: Call<List<UserInfo>>, t: Throwable) {
                    //TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<List<UserInfo>>,
                    response: Response<List<UserInfo>>
                ) {
                    userInfoAdapter.submitList(response.body())
                }
            }
        )
    }

    private fun getPersonalInfo(id: Int) {
        val service = RetrofitClient.retrofitService.getPersonalInfo(id).enqueue(
            object : Callback<PersonalInfo> {
                override fun onFailure(call: Call<PersonalInfo>, t: Throwable) {
                    //TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<PersonalInfo>,
                    response: Response<PersonalInfo>
                ) {
                    val personalInfo = response.body()!!

                    val personalAccount = findViewById<TextView>(R.id.personal_account)
                    val toPay = findViewById<TextView>(R.id.to_pay)
                    val money = findViewById<TextView>(R.id.money)

                    personalAccount.text = "ЛС: ${personalInfo?.personalAccount}"
                    toPay.text = "${getString(R.string.to_pay_october)} ${
                        String.format(
                            "%.2f",
                            personalInfo?.toPay
                        )
                    }${getString(R.string.ruble_symbol)}"
                    money.text = "${String.format("%.2f", personalInfo?.money)} ${getString(R.string.ruble_symbol)}"
                }
            }
        )
    }
}