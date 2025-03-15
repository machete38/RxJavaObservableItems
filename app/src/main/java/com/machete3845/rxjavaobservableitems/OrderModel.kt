package com.machete3845.rxjavaobservableitems

import java.io.Serializable

data class OrderModel(
    val id: Int,
    val name: String,
    val price: Int,
    val description: String
) : Serializable
