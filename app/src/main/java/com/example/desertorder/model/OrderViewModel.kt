package com.example.desertorder.model

import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

const val PRICE_DESERT = 2.00
const val SAME_DAY_ORDER = 3.00

class OrderViewModel: ViewModel() {

    private val _quantity = MutableLiveData<Int>()
    val quantity:LiveData<Int>  = _quantity

    private val _typeDesert = MutableLiveData<String>()
    val typeDesert:LiveData<String> = _typeDesert

    private val _dateOrder = MutableLiveData<String>()
    val dateOrder:LiveData<String> = _dateOrder

    private val _price = MutableLiveData<Double>()
    val price:LiveData<String> = Transformations.map(_price){
        NumberFormat.getCurrencyInstance().format(it)
    }

    val dateOptions = pickupOptions()

    init {
        resetOrder()
    }
    fun resetOrder(){
        _quantity.value = 0
        _typeDesert.value = ""
        _dateOrder.value = dateOptions[0]
        _price.value = 0.0
    }
    fun setQuatity(amount:Int){
        _quantity.value = amount
        calculatePrice()
    }
    fun setTypeDesert(typesDesert:String){
        _typeDesert.value = typesDesert
    }
    fun setDate(date:String){
        _dateOrder.value = date
        calculatePrice()
    }
    fun hasNoTypeDesert():Boolean{
        return _typeDesert.value.isNullOrEmpty()
    }
    fun pickupOptions():List<String>{
        val pickDates = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4){
            pickDates.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE,1)
        }
        return pickDates
    }
    fun calculatePrice(){
        _price.value = PRICE_DESERT* (_quantity.value?:0)
        if(_dateOrder.value.equals(dateOptions[0])){
            _price.value = _price.value?.plus(SAME_DAY_ORDER)
        }
    }
}