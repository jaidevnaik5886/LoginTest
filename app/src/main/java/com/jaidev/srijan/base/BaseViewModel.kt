package com.jaidev.srijan.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaidev.srijan.utils.BaseEvent
import com.jaidev.srijan.utils.SingleLiveEvent
import com.jaidev.srijan.utils.ToastEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val bus: SingleLiveEvent<BaseEvent> = SingleLiveEvent()
    val isBusy = MutableLiveData<Boolean>()

    fun sendEvent(event: BaseEvent) {
        bus.postValue(event)
    }

    //Make network call
    fun launch(
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return viewModelScope.launch {
            try {
                isBusy.postValue(true)
                block()
                isBusy.postValue(false)
            } catch (e: Exception) {
                isBusy.postValue(false)
                sendEvent(ToastEvent(e.message ?: ""))
            }
        }
    }
}