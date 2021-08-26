package com.jaidev.srijan.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jaidev.srijan.R
import com.jaidev.srijan.base.BaseActivity
import com.jaidev.srijan.base.BaseFragment
import com.jaidev.srijan.base.BaseViewModel
import com.jaidev.srijan.databinding.FragmentSplashBinding
import com.jaidev.srijan.utils.BaseEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    val model: SplashViewModel by viewModels()

    override fun attachBinding() {
    }

    override fun getVM(): BaseViewModel = model

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity is BaseActivity<*>) {
            (activity as BaseActivity<*>).supportActionBar?.hide()
        }
    }

    override fun handleEvent(event: BaseEvent) {
        super.handleEvent(event)
        when (event) {
            is NavToLogin -> {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToSignInFragment())
            }
        }
    }


}