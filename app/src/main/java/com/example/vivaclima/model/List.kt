package com.example.vivaclima.model

import kotlin.collections.List

data class List(val dt:String,val sunrise:String,val sunset:String,val temp:Temp?=null,val feels_like:Feels_like?=null,
                val pressure:String,val humidity:Int,val weather:List<Weather>)