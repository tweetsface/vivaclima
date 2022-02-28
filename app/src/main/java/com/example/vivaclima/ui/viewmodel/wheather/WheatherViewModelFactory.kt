package com.example.vivaclima.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vivaclima.repository.WheatherRepository

class WheatherViewModelFactory (private val wheatherRepository: WheatherRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WheatherViewModel(wheatherRepository) as T
    }

}