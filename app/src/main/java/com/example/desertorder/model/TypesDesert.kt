package com.example.desertorder.model

enum class TypesDesert {
    CHOCOLATE_CAKE,OZNEI_TMARIM,CHOCOLATE_COOKIE,BRIGADEIRO
}

data class Desert(val tpeDesert:TypesDesert,val dayOrder:String,val amount:Int)