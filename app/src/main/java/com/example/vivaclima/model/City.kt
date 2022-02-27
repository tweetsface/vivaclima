package com.example.vivaclima.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



    data class  City(val id: Long, val name: String, @Expose var coord: Coord? =null,
                     val country:String, val population:Long, val timezone:Long)

