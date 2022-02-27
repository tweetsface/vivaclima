package com.example.vivaclima.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.vivaclima.R
import com.example.vivaclima.config.WheaderApi
import com.example.vivaclima.core.RetrofitHelper
import com.example.vivaclima.repository.WheatherRepository
import com.example.vivaclima.viewmodel.WheatherViewModel
import com.example.vivaclima.viewmodel.WheatherViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var wheatherViewModel: WheatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var apiInterfaz = RetrofitHelper.getInstance().create(WheaderApi::class.java)
        var wheatherRepository = WheatherRepository(apiInterfaz)
        wheatherViewModel = ViewModelProvider(this, WheatherViewModelFactory(wheatherRepository)).get()
        wheatherViewModel.wheather.observe(this) {
            Log.d("ri", it.city?.country.toString())
        }
    }
}