package com.example.vivaclima.model

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import java.util.*
import kotlin.collections.List

data class WheatherResponse(@Expose var city:City?=null, val cod:Int, val message:String,
                            val cnt:String,val list:List<com.example.vivaclima.model.List>)