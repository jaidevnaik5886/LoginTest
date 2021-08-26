package com.jaidev.srijan.ui.splash

import com.jaidev.srijan.base.BaseViewModel
import com.jaidev.srijan.utils.BaseEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) : BaseViewModel() {

    init {
        GlobalScope.launch {
            delay(2000)
            sendEvent(NavToLogin())
        }
    }
}

class NavToLogin() : BaseEvent()