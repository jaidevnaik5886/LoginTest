package com.jaidev.srijan.ui.signin

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.jaidev.srijan.base.BaseViewModel
import com.jaidev.srijan.utils.BaseEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
) : BaseViewModel() {

    val username: MutableLiveData<String> = MutableLiveData<String>("")
    val password: MutableLiveData<String> = MutableLiveData<String>("")
    var token = ""
    var loginMediator: MediatorLiveData<Boolean> = MediatorLiveData()

    init {
        loginMediator.addSource(username) {
            loginMediator.value = password.value?.isNotBlank() == true && it?.isNotBlank() ?: false
        }

        loginMediator.addSource(password) {
            loginMediator.value = username.value?.isNotBlank() == true && it?.isNotBlank() ?: false
        }
    }

    fun onLoginClicked() {
        if (username.value!!.trim().isNotEmpty() && password.value!!.trim().isNotEmpty()) {
            performLogin()
        }
    }

    private fun performLogin() {
        launch {
            token = "loggedIn"
            sendEvent(NavToHomePage())
        }
    }

}


class NavToHomePage() : BaseEvent()