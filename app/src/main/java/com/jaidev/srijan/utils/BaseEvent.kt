package com.jaidev.srijan.utils

abstract class BaseEvent {

}

data class ToastEvent(val message: String): BaseEvent()
