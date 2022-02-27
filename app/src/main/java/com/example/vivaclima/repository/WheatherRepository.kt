package com.example.vivaclima.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.vivaclima.config.WheaderApi
import com.example.vivaclima.core.RetrofitHelper
import com.example.vivaclima.model.City
import com.example.vivaclima.model.WheatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class WheatherRepository(private val wheaderApi: WheaderApi) {

   private val wheatherLiveData= MutableLiveData<WheatherResponse>()
    val wheather:LiveData<WheatherResponse>
    get() = wheatherLiveData


    suspend fun getCities() {
        val result = wheaderApi.getCity()
        if (result.isSuccessful){
         wheatherLiveData.postValue(result.body())
        }
    }

}