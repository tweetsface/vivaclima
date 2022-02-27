package com.example.vivaclima.config

import com.example.vivaclima.model.City
import com.example.vivaclima.model.WheatherResponse
import retrofit2.Response
import retrofit2.http.GET


interface WheaderApi {
    @GET("data/2.5/forecast/daily?q=culiacan,mx&cnt=7&appid=dfa99b749067116f9b9fae273403cc63&units=metric")
    suspend fun getCity():Response<WheatherResponse>
}