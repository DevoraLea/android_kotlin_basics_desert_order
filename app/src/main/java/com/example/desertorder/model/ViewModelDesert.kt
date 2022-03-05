package com.example.desertorder.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModelDesert {

    private lateinit var  _desert:MutableLiveData<Desert>
    val desert:LiveData<Desert> get() = _desert
}