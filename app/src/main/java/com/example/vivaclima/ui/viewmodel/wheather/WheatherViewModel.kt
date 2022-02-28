package com.example.vivaclima.ui.view.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vivaclima.model.WheatherResponse
import com.example.vivaclima.repository.WheatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WheatherViewModel(private val wheatherRepository: WheatherRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
         wheatherRepository.getCities()
        }
    }
    val wheather : LiveData<WheatherResponse>
    get()  = wheatherRepository.wheather
}