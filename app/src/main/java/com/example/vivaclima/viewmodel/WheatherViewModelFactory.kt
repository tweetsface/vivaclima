package com.example.vivaclima.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vivaclima.repository.WheatherRepository
import kotlin.contracts.Returns

class WheatherViewModelFactory (private val wheatherRepository: WheatherRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WheatherViewModel(wheatherRepository) as T
    }

}