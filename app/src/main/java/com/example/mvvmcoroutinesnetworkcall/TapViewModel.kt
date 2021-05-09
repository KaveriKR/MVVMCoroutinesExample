package com.example.mvvmcoroutinesnetworkcall

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TapViewModel: ViewModel() {

    private var noOfTaps: Int = 0
    public var taps : MutableLiveData<String> = MutableLiveData()

    fun updateTaps() {
        // launch a coroutine in viewModelScope
        viewModelScope.launch {
            noOfTaps++
            // suspend this coroutine for one second
            delay(1_000)
            // resume in the main dispatcher
            // _snackbar.value can be called directly from main thread
            taps.value = "$noOfTaps taps"
        }
    }

}