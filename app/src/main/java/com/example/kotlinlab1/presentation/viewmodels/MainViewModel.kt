package com.example.kotlinlab1.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlab1.data.models.PersonalInfo
import com.example.kotlinlab1.data.models.Tariff
import com.example.kotlinlab1.data.models.UserInfo
import com.example.kotlinlab1.domain.usecases.GetPersonalInfoByIdUseCase
import com.example.kotlinlab1.domain.usecases.GetTariffsUseCase
import com.example.kotlinlab1.domain.usecases.GetUserInfoUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

private const val USER_ID: Int = 11010010
class MainViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getTariffsUseCase: GetTariffsUseCase,
    private val getPersonalInfoByIdUseCase: GetPersonalInfoByIdUseCase
) : ViewModel() {

    private val coroutineScope = CoroutineScope(CoroutineName("MainViewModelScope"))

    val tariffLivedata = MutableLiveData<List<Tariff>>()
    val userInfoLivedata = MutableLiveData<List<UserInfo>>()
    val personalInfoLivedata = MutableLiveData<PersonalInfo>()

    fun loadTariffs() {
        coroutineScope.launch(Dispatchers.IO) {
            val tariffs = getTariffsUseCase.execute()
            tariffLivedata.postValue(tariffs)
        }
    }

    fun loadUserInfo() {
        coroutineScope.launch(Dispatchers.IO) {
            val userInfo = getUserInfoUseCase.execute()
            userInfoLivedata.postValue(userInfo)
        }
    }

    fun loadPersonalInfo() {
        coroutineScope.launch(Dispatchers.IO) {
            val personalInfo = getPersonalInfoByIdUseCase.execute(USER_ID)
            personalInfoLivedata.postValue(personalInfo)
        }
    }
}