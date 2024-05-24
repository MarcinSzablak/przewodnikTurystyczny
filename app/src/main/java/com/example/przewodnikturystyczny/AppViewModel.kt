package com.example.przewodnikturystyczny

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
    val countNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }


}