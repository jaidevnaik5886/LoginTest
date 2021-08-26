package com.jaidev.srijan.ui.signin

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.jaidev.srijan.R
import com.jaidev.srijan.base.BaseViewModel
import com.jaidev.srijan.common.ResourceHelper
import com.jaidev.srijan.extensions.isValidPassword
import com.jaidev.srijan.extensions.isValidUsername
import com.jaidev.srijan.utils.BaseEvent
import com.jaidev.srijan.utils.ToastEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    val resourceHelper: ResourceHelper
) : BaseViewModel() {

    val username: MutableLiveData<String> = MutableLiveData<String>("")
    val password: MutableLiveData<String> = MutableLiveData<String>("")
    var token = ""
    var loginMediator: MediatorLiveData<Boolean> = MediatorLiveData()

    init {
        loginMediator.addSource(username) {
            loginMediator.value = password.value?.isNotBlank() == true && it?.isValidUsername() ?: false
        }

        loginMediator.addSource(password) {
            loginMediator.value = username.value?.isNotBlank() == true && it?.isValidPassword() ?: false
        }

    }

    fun onLoginClicked() {
        if (isCredentialsValid()) {
            performLogin()
        }
    }

    private fun isCredentialsValid(): Boolean {
        return when {
            !username.value?.trim().isValidUsername() -> {
                sendEvent(ToastEvent(resourceHelper.getString(R.string.enter_valid_username)))
                false
            }
            !password.value!!.trim().isValidPassword() -> {
                sendEvent(ToastEvent(resourceHelper.getString(R.string.enter_valid_password)))
                false
            }
            else -> {
                true
            }
        }
    }

    private fun performLogin() {
        launch {
            token = "loggedIn"
            sendEvent(NavToHomePage(username.value.toString()))
        }
    }

}




class NavToHomePage(val username : String) : BaseEvent()