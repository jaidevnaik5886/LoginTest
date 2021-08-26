package com.jaidev.srijan.ui.home


import androidx.lifecycle.MutableLiveData
import com.jaidev.srijan.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) :
    BaseViewModel() {
    fun onDataRecieved(user: String) {
        username.value = user
    }

    val username: MutableLiveData<String> = MutableLiveData<String>("")

}

